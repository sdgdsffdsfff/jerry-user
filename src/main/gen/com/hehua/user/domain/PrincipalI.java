/*
 * 由系统于2014-08-01 17:00:03生成，请勿人为进行任何修改！
 */

package com.hehua.user.domain;

import java.util.*;

public class PrincipalI{
    protected long id;
    protected Date cts;
    protected Date uts;
    protected long uid;
    protected String alias;
    
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
    
    public String getAlias(){
        return alias;
    }
    public void setAlias(String alias){
        this.alias=alias;
    }
    
}
