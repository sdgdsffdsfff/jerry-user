/**
 * 
 */
package com.hehua.user.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.hehua.user.domain.Baby;

/**
 * @author zhihua
 *
 */
public class BabyView {

    private int status;

    /**
     * 是否已经设置了
     */
    private boolean isset = true;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date edc;

    private int gender;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 
     */
    public BabyView() {
        super();
    }

    public BabyView(Baby baby) {
        super();
        this.edc = baby.getEdc();
        this.gender = baby.getGender();
        this.birthday = baby.getBirthday();
        this.status = Math.max(0, baby.getStatus());
        this.isset = baby.getStatus() >= 0;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public boolean isIsset() {
        return isset;
    }

    public void setIsset(boolean isset) {
        this.isset = isset;
    }

}
