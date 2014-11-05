package com.hehua.user.exeception;

import com.hehua.commons.exception.BusinessException;
import com.hehua.user.model.UserCode;

/**
 * Created by liuweiwei on 14-10-8.
 */
public class QRCodeNotExistException extends BusinessException {

    public QRCodeNotExistException() {
        super(UserCode.QRCODE_NOT_EXISTS);
    }
}
