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
public class UsernameNotFoundException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public UsernameNotFoundException() {
        super(UserCode.USER_NOT_EXIST);
    }

}
