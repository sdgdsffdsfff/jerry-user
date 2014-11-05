package com.hehua.user.exeception;

import com.hehua.commons.exception.BusinessException;
import com.hehua.user.model.UserCode;

/**
 * Created by liuweiwei on 14-9-17.
 */
public class NickNameIllegalException extends BusinessException {

    public NickNameIllegalException() {
        super(UserCode.NICKNAME_ILLEGAL);
    }
}
