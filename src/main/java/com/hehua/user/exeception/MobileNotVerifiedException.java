package com.hehua.user.exeception;

import com.hehua.commons.exception.BusinessException;
import com.hehua.user.model.UserCode;

/**
 * @author zhihua
 *
 */
public class MobileNotVerifiedException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public MobileNotVerifiedException() {
        super(UserCode.MOBILE_NOT_VERIFIED);
    }

}
