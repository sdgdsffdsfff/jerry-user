package com.hehua.user.model;

/**
 * @author YaoZhidong
 * @version 1.0
 * @created 14-8-4
 */
public class UserResult<T> {
    private UserCode code;
    private T data;

    public UserResult(UserCode code, T data) {
        this.code = code;
        this.data = data;
    }

    public UserCode getCode() {
        return code;
    }

    public void setCode(UserCode code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("UserResult{code=%s, data=%s}", code, data);
    }
}
