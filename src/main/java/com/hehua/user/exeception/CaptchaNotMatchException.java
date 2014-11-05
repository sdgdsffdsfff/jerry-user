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
public class CaptchaNotMatchException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public CaptchaNotMatchException() {
        super(UserCode.CAPTCHA_ERROR);
    }
}
