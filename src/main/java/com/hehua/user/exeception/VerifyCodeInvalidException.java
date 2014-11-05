package com.hehua.user.exeception;

import com.hehua.commons.exception.BusinessException;
import com.hehua.user.model.UserCode;

public class VerifyCodeInvalidException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public VerifyCodeInvalidException() {
        super(UserCode.CAPTCHA_ERROR);
    }

}
