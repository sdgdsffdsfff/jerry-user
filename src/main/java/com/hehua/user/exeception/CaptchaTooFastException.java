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
public class CaptchaTooFastException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public CaptchaTooFastException() {
        super(UserCode.CAPTCHA_TOO_FAST);
    }
}
