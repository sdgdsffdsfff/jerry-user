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
public class FreshTokenNotFoundException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public FreshTokenNotFoundException() {
        super(UserCode.FRESH_TOKEN_NOT_FOUND);
    }

}
