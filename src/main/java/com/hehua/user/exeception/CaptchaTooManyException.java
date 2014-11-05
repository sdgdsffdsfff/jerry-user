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
public class CaptchaTooManyException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public CaptchaTooManyException() {
        super(UserCode.CAPTCHA_TOO_MANY);
    }
}
