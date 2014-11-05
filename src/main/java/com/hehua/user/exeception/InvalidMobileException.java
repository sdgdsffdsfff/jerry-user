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
public class InvalidMobileException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param message
     * @param cause
     */
    public InvalidMobileException(String message, Throwable cause) {
        super(UserCode.INVALID_MOBILE, message, cause);
    }

    /**
     * @param message
     */
    public InvalidMobileException(String message) {
        super(UserCode.INVALID_MOBILE, message);
    }

    /**
     * 
     */
    public InvalidMobileException() {
        super(UserCode.INVALID_MOBILE);
    }

}
