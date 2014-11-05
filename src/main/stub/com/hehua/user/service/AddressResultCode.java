/**
 * 
 */
package com.hehua.user.service;

import com.hehua.commons.model.MetaCode;

/**
 * @author zhihua
 *
 */
public enum AddressResultCode implements MetaCode {

    INVALID_RECEIVER(31001, "收件人必须为1-25个字符"),

    INVALID_PROVINCE(31002, "非法省份"),

    INVALID_CITY(31003, "非法城市"),

    INVALID_COUNTY(31004, "非法区"),

    INVALID_DETAIL(31004, "非法详细地址不完善"),

    INVALID_POSTCODE(31005, "非法邮编"),

    TOO_MANY_ADDRESSES(31006, "添加地址总数不能超过20条"),

    ADDRESS_NOT_FOUND(31007, "地址未找到")

    ;

    private final int code;

    private final String message;

    /**
     * @param code
     * @param message
     */
    private AddressResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
