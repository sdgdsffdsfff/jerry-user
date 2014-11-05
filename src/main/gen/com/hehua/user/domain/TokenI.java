/*
 * 由系统于2014-08-01 17:44:04生成，请勿人为进行任何修改！
 */

package com.hehua.user.domain;

import java.util.*;

public class TokenI{
    protected long id;
    protected Date cts;
    protected Date uts;
    protected long uid;
    protected String token;
    protected String device;
    protected String os;
    protected Date lastlogin;
    
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
    
    public long getUid(){
        return uid;
    }
    public void setUid(long uid){
        this.uid=uid;
    }
    
    public String getToken(){
        return token;
    }
    public void setToken(String token){
        this.token=token;
    }
    
    public String getDevice(){
        return device;
    }
    public void setDevice(String device){
        this.device=device;
    }
    
    public String getOs(){
        return os;
    }
    public void setOs(String os){
        this.os=os;
    }
    
    public Date getLastlogin(){
        return lastlogin;
    }
    public void setLastlogin(Date lastlogin){
        this.lastlogin=lastlogin;
    }
    
}
