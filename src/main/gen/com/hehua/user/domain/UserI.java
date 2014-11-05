/*
 * 由系统于2014-08-01 17:00:03生成，请勿人为进行任何修改！
 */

package com.hehua.user.domain;

import java.util.Date;

public class UserI {

    protected long id;

    protected Date cts;

    protected Date uts;

    protected String account;

    protected String name;

    protected String desc;

    protected boolean daren;

    protected String avatar;

    protected long avatarid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCts() {
        return cts;
    }

    public void setCts(Date cts) {
        this.cts = cts;
    }

    public Date getUts() {
        return uts;
    }

    public void setUts(Date uts) {
        this.uts = uts;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Deprecated
    public String getAvatar() {
        return avatar;
    }

    @Deprecated
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isDaren() {
        return daren;
    }

    public void setDaren(boolean daren) {
        this.daren = daren;
    }

    public long getAvatarid() {
        return avatarid;
    }

    public void setAvatarid(long avatarid) {
        this.avatarid = avatarid;
    }

}
