/*
 * 由系统于2014-08-01 17:35:56生成。
 */

package com.hehua.user.service;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.hehua.commons.NormalizeUtils;
import com.hehua.commons.ValidationUtils;
import com.hehua.commons.time.DateUtils;
import com.hehua.event.EventDispatcher;
import com.hehua.event.impl.SmsEvent;
import com.hehua.user.dao.CaptchaDAO;
import com.hehua.user.domain.Captcha;
import com.hehua.user.exeception.CaptchaExpiredException;
import com.hehua.user.exeception.CaptchaNotMatchException;
import com.hehua.user.exeception.CaptchaTooFastException;
import com.hehua.user.exeception.CaptchaTooManyException;
import com.hehua.user.exeception.InvalidCaptchaException;
import com.hehua.user.exeception.InvalidMobileException;

@javax.inject.Named
public class CaptchaService {

    @Autowired
    private CaptchaDAO captchaDAO;

    @Autowired
    private EventDispatcher eventDispatcher;

    private static final Logger log = Logger.getLogger(CaptchaService.class);

    public boolean checkCaptcha(String service, String mobile, String captcha)
            throws InvalidMobileException, CaptchaExpiredException, CaptchaNotMatchException,
            InvalidCaptchaException {

        mobile = NormalizeUtils.normalizeMobile(mobile);

        // 验证手机号是否合法
        if (!ValidationUtils.isValidMobile(mobile)) {
            throw new InvalidMobileException();
        }

        if (!StringUtils.isNumeric(captcha) || StringUtils.length(captcha) != 4) {
            throw new InvalidCaptchaException();
        }

        Captcha lastCaptcha = captchaDAO.getLastCaptchaByServiceAndPhone(service, mobile);
        if (lastCaptcha == null) {
            throw new CaptchaNotMatchException();
        }

        if (!StringUtils.equals(lastCaptcha.getCaptcha(), captcha)) {
            throw new CaptchaNotMatchException();
        }

        // 过期了
        if (DateUtils.intervalMintues(new Date(), lastCaptcha.getCts()) >= 30) {
            throw new CaptchaExpiredException();
        }

        lastCaptcha.setStatus(Captcha.VERIFIED);
        captchaDAO.updateCaptchaStatus((int) lastCaptcha.getId(), lastCaptcha.getStatus());
        return true;
    }

    private void disableOldCaptcha(String service, String phone) {
        captchaDAO.updateCaptchaStatuses(service, phone, Captcha.CREATED, Captcha.OVERRIED);
    }

    public Captcha sendCaptcha(String service, String mobile) throws InvalidMobileException,
            CaptchaTooFastException, CaptchaTooManyException {
        mobile = NormalizeUtils.normalizeMobile(mobile);

        // 验证手机号是否合法
        if (!ValidationUtils.isValidMobile(mobile)) {
            throw new InvalidMobileException();
        }

        // 是否可以重发
        Captcha lastCaptcha = captchaDAO.getLastCaptchaByServiceAndPhone(service, mobile);
        if (lastCaptcha != null && DateUtils.intervalSeconds(new Date(), lastCaptcha.getCts()) < 60) {
            throw new CaptchaTooFastException();
        }

        // 今天发送量 
        Date startTime = org.apache.commons.lang3.time.DateUtils
                .truncate(new Date(), Calendar.DATE);
        int todayCaptchaCount = captchaDAO.getCaptchaCountByServiceAndPhoneAndStartTime(service,
                mobile, startTime);
        if (todayCaptchaCount >= 20) {
            throw new CaptchaTooManyException();
        }

        disableOldCaptcha(service, mobile);

        Captcha c = new Captcha();
        c.setPhone(mobile);
        c.setService(service);
        c.setCaptcha(generateCaptcha());
        c.setCts(new Date());
        c.setUts(c.getCts());
        c.setExpire(new Date(c.getCts().getTime() + TimeUnit.MINUTES.toMillis(30)));

        captchaDAO.createCaptcha(c);

        // TODO 踢出去
        String message = null;
        switch (service) {
            case Captcha.SERVICE_FINDPSW:
                message = c.getCaptcha() + "（荷花亲子找回密码验证码）请在30分钟内完成操作，工作人员不会向你索要，请勿向任何人泄露。";
                break;
            case Captcha.SERVICE_REGISTER:
                message = c.getCaptcha() + "（荷花亲子验证码）请在30分钟内完成注册，如非本人操作请忽略。";
                break;
        }

        if (message != null) {
            eventDispatcher.post(new SmsEvent(mobile, message, new Date()));
        }
        return c;
    }

    private String generateCaptcha() {
        return RandomStringUtils.randomNumeric(4);
    }
}
