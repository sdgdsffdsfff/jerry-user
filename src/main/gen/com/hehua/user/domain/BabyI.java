/*
 * 由系统于2014-08-07 15:56:07生成，请勿人为进行任何修改！
 */

package com.hehua.user.domain;

import java.util.Date;

public class BabyI {

    protected long id;

    protected long uid;

    protected int status;

    protected Date edc;

    protected int gender;

    protected Date birthday;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isIsset() {
        return this.status >= 0;
    }

    public Date getEdc() {
        return edc;
    }

    public void setEdc(Date edc) {
        this.edc = edc;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
