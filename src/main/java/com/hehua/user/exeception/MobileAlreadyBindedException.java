package com.hehua.user.exeception;

import com.hehua.commons.exception.BusinessException;
import com.hehua.user.model.UserCode;

/**
 * @author zhihua
 *
 */
public class MobileAlreadyBindedException extends BusinessException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MobileAlreadyBindedException() {
        super(UserCode.MOBILE_ALREADY_BINDED);
    }

}
