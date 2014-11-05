package com.hehua.user.exeception;

import com.hehua.commons.exception.BusinessException;
import com.hehua.user.model.UserCode;

public class VerifyCodeExpiredException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public VerifyCodeExpiredException() {
        super(UserCode.CAPTCHA_EXPIRED);
    }

}
