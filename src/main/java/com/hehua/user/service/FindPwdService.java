/**
 * 
 */
package com.hehua.user.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hehua.commons.NormalizeUtils;
import com.hehua.commons.ValidationUtils;
import com.hehua.commons.time.DateUtils;
import com.hehua.user.domain.Captcha;
import com.hehua.user.domain.User;
import com.hehua.user.exeception.CaptchaExpiredException;
import com.hehua.user.exeception.CaptchaNotMatchException;
import com.hehua.user.exeception.CaptchaTooFastException;
import com.hehua.user.exeception.CaptchaTooManyException;
import com.hehua.user.exeception.ChangePwdTokenExpiredException;
import com.hehua.user.exeception.ChangePwdTokenNotFoundException;
import com.hehua.user.exeception.InvalidCaptchaException;
import com.hehua.user.exeception.InvalidMobileException;
import com.hehua.user.exeception.UsernameNotFoundException;
import com.hehua.user.model.ChangePwdToken;

/**
 * @author zhihua
 *
 */
@Service
public class FindPwdService {

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private UserManager userManager;

    @Autowired
    private CredentialService credentialService;

    @Autowired
    private ChangePwdTokenManager changePwdTokenManager;

    public void sendFindPwdCaptcha(String mobile) throws InvalidMobileException,
            UsernameNotFoundException, CaptchaTooFastException, CaptchaTooManyException {

        mobile = NormalizeUtils.normalizeMobile(mobile);

        // 验证手机号是否合法
        if (!ValidationUtils.isValidMobile(mobile)) {
            throw new InvalidMobileException();
        }

        // 账号是否存在
        User user = userManager.getUserByMobile(mobile);
        if (user == null) {
            throw new UsernameNotFoundException();
        }

        // 最近找回密码时间时间
        Captcha captcha = captchaService.sendCaptcha(Captcha.SERVICE_FINDPSW, mobile);
    }

    public void checkFindPwdCaptcha(String mobile, String captcha) throws InvalidMobileException,
            UsernameNotFoundException, CaptchaExpiredException, CaptchaNotMatchException,
            InvalidCaptchaException {
        mobile = NormalizeUtils.normalizeMobile(mobile);

        // 验证手机号是否合法
        if (!ValidationUtils.isValidMobile(mobile)) {
            throw new InvalidMobileException();
        }

        // 账号是否存在
        User user = userManager.getUserByMobile(mobile);
        if (user == null) {
            throw new UsernameNotFoundException();
        }

        // 检测验证码
        captchaService.checkCaptcha(Captcha.SERVICE_FINDPSW, mobile, captcha);

    }

    public ChangePwdToken generateChangePwdToken(User user) {
        // 生成修改密码临时凭据
        ChangePwdToken changePwdToken = new ChangePwdToken();
        String token = UUID.randomUUID().toString();
        Date now = new Date();
        changePwdToken.setCts(now);
        changePwdToken.setUts(now);
        changePwdToken.setUid((int) user.getId());
        changePwdToken.setToken(token);
        changePwdToken.setMobile(user.getAccount());
        changePwdTokenManager.addChangePwdToken(changePwdToken);
        return changePwdToken;
    }

    public void changePwd(String mobile, String token, String passwordMd5)
            throws InvalidMobileException, UsernameNotFoundException,
            ChangePwdTokenExpiredException, ChangePwdTokenNotFoundException {

        mobile = NormalizeUtils.normalizeMobile(mobile);

        // 验证手机号是否合法
        if (!ValidationUtils.isValidMobile(mobile)) {
            throw new InvalidMobileException();
        }

        User user = userManager.getUserByMobile(mobile);
        if (user == null) {
            throw new UsernameNotFoundException();
        }

        ChangePwdToken changePswToken = changePwdTokenManager.getChangePwdTokenByToken(token);
        if (token == null) {
            throw new ChangePwdTokenNotFoundException();
        }

        if (changePswToken.getUid() != user.getId()) {
            throw new ChangePwdTokenNotFoundException();
        }

        // 五分钟没有修改，即过期，重新走流程
        if (DateUtils.intervalMintues(new Date(), changePswToken.getCts()) >= 5) {
            throw new ChangePwdTokenExpiredException();
        }

        credentialService.updatePassword(user.getId(), passwordMd5);

    }
}
