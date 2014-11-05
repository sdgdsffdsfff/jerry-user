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
public class PasswordNotMatchException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param message
     * @param cause
     */
    public PasswordNotMatchException(String message, Throwable cause) {
        super(UserCode.PASSWORD_ERROR, message, cause);
    }

    /**
     * @param message
     */
    public PasswordNotMatchException(String message) {
        super(UserCode.PASSWORD_ERROR, message);
    }

    public PasswordNotMatchException() {
        super(UserCode.PASSWORD_ERROR);
    }
}
