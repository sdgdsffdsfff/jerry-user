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
public class InvalidPasswordException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param message
     * @param cause
     */
    public InvalidPasswordException(String message, Throwable cause) {
        super(UserCode.INVALID_PASSWORD, message, cause);
    }

    /**
     * @param message
     */
    public InvalidPasswordException(String message) {
        super(UserCode.INVALID_PASSWORD, message);
    }

    public InvalidPasswordException() {
        super(UserCode.INVALID_PASSWORD);
    }
}
