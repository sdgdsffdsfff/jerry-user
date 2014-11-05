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
public class InvalidNicknameException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param message
     * @param cause
     */
    public InvalidNicknameException(String message, Throwable cause) {
        super(UserCode.INVALID_NICKNAME, message, cause);
    }

    /**
     * @param message
     */
    public InvalidNicknameException(String message) {
        super(UserCode.INVALID_NICKNAME, message);
    }

    /**
     * 
     */
    public InvalidNicknameException() {
        super(UserCode.INVALID_NICKNAME);
    }

}
