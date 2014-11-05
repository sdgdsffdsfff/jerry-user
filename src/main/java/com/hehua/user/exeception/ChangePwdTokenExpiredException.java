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
public class ChangePwdTokenExpiredException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ChangePwdTokenExpiredException() {
        super(UserCode.CHANGE_PWD_TOKEN_EXPIRED);
    }
}
