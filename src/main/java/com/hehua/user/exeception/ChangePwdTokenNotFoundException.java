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
public class ChangePwdTokenNotFoundException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ChangePwdTokenNotFoundException() {
        super(UserCode.CHANGE_PWD_TOKEN_ERROR);
    }

}
