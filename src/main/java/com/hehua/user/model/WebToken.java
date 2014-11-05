package com.hehua.user.model;

import java.util.Date;

/**
 * Created by liuweiwei on 14-10-14.
 * 网页登录token
 */
public class WebToken {

    private long uid;
    private String token;
    private Date uts;

    /**
     * 是否过期，暂时永不过期
     * @return
     */
    public boolean isExpired() {
        return false;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getUts() {
        return uts;
    }

    public void setUts(Date uts) {
        this.uts = uts;
    }
}
