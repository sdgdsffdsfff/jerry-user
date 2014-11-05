/*
 * 由系统于2014-08-01 17:56:09生成，请勿人为进行任何修改！
 */

package com.hehua.user.domain;

import java.util.*;

public class FreshtokenI{
    protected long id;
    protected Date cts;
    protected Date uts;
    protected String phone;
    protected String freshtoken;
    protected Date expire;
    
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
    
    public String getFreshtoken(){
        return freshtoken;
    }
    public void setFreshtoken(String freshtoken){
        this.freshtoken=freshtoken;
    }
    
    public Date getExpire(){
        return expire;
    }
    public void setExpire(Date expire){
        this.expire=expire;
    }
    
}
