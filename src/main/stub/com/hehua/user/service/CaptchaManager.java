/**
 * 
 */
package com.hehua.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hehua.user.dao.CaptchaDAO;
import com.hehua.user.domain.Captcha;

/**
 * @author zhihua
 *
 */
@Component
public class CaptchaManager {

    @Autowired
    private CaptchaDAO captchaDAO;

    public Captcha getLastCaptcha(String service, String mobile) {
        // TODO
        return null;
    }

    public int getTodayCaptchaCount(String service, String mobile) {
        return 1;
    }

    public int getTodayCaptchaCount(String mobile) {
        return 1;
    }

}
