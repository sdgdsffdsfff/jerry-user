/**
 * 
 */
package com.hehua.user.exeception;

import com.hehua.commons.exception.BusinessException;
import com.hehua.user.model.UserCode;

/**
 * @author zhihua
 *
 */
public class InvalidCaptchaException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public InvalidCaptchaException() {
        super(UserCode.CAPTCHA_ERROR);
    }

}
