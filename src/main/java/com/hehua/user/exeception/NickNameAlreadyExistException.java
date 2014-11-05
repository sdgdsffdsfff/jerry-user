package com.hehua.user.exeception;

import com.hehua.commons.exception.BusinessException;
import com.hehua.user.model.UserCode;

/**
 * Created by liuweiwei on 14-9-17.
 */
public class NickNameAlreadyExistException extends BusinessException {

    public NickNameAlreadyExistException() {
        super(UserCode.NICKNAME_ALREADY_EXISTS);
    }
}
