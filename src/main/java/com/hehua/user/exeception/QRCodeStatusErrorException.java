package com.hehua.user.exeception;

import com.hehua.commons.exception.BusinessException;
import com.hehua.user.model.UserCode;

/**
 * Created by liuweiwei on 14-10-8.
 */
public class QRCodeStatusErrorException extends BusinessException {

    public QRCodeStatusErrorException() {
        super(UserCode.QRCODE_STATUS_ERROR);
    }
}
