/*
 * 由系统于2014-08-01 17:56:09生成，请勿人为进行任何修改！
 */

package com.hehua.user.domain;

import java.util.*;

public class CaptchaI{
    protected long id;
    protected Date cts;
    protected Date uts;
    protected String phone;
    protected String captcha;
    protected Date expire;
    protected String service;
    protected int status;
    
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
    
    public Date getCts(){
        return cts;
    }
    public void setCts(Date cts){
        this.cts=cts;
    }
    
    public Date getUts(){
        return uts;
    }
    public void setUts(Date uts){
        this.uts=uts;
    }
    
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    
    public String getCaptcha(){
        return captcha;
    }
    public void setCaptcha(String captcha){
        this.captcha=captcha;
    }
    
    public Date getExpire(){
        return expire;
    }
    public void setExpire(Date expire){
        this.expire=expire;
    }
    
    public String getService() {
        return service;
    }
    
    public void setService(String service) {
        this.service = service;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
