package com.hehua.user.model;

import com.hehua.commons.model.MetaCode;

/**
 * @author YaoZhidong
 * @version 1.0
 * @created 14-8-4
 */
public enum UserCode implements MetaCode {
    USER_ALREADY_EXIST(10001, "用户已存在"),

    USER_NOT_EXIST(10002, "用户不存在"),

    CAPTCHA_ERROR(10003, "验证码错误或已过期"),

    CAPTCHA_EXPIRED(10004, "验证码已过期"),

    PASSWORD_ERROR(10005, "密码错误"),

    INVALID_BABY_PARAMS(10006, "参数错误"),

    CAPTCHA_TOO_FAST(10007, "发送验证码太频繁"),

    INVALID_MOBILE(10008, "手机号码格式不正确"),

    INVALID_PASSWORD(10008, "密码格式不正确"),

    MOBILE_ALREADY_BINDED(10009, "手机已经绑定"),

    MOBILE_NOT_VERIFIED(10010, "手机未验证"),

    CAPTCHA_TOO_MANY(10011, "发送验证码超过限定次数"),

    CHANGE_PWD_TOKEN_EXPIRED(10012, "修改密码停留时间过长"),

    CHANGE_PWD_TOKEN_ERROR(10013, "修改密码错误"),

    FRESH_TOKEN_NOT_FOUND(10014, "注册token未找到或者已过期"),

    INVALID_NICKNAME(10015, "昵称不合法，必须为1-8中文、或者英文字符"),

    NICKNAME_ILLEGAL(10014, "昵称不能包含系统预留关键字"),

    NICKNAME_ALREADY_EXISTS(10015, "昵称已被注册"),

    QRCODE_NOT_EXISTS(10016, "qr码不存在"),

    QRCODE_STATUS_ERROR(10017, "qr码状态错误"),

    ;

    private int code;

    private String desc;

    UserCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String getMessage() {
        return desc;
    }

    @Override
    public String toString() {
        return String.format("UserCode{code=%d, desc='%s'}", code, desc);
    }
}
