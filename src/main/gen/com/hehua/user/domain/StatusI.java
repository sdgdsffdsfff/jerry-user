/*
 * 由系统于2014-08-01 17:35:56生成，请勿人为进行任何修改！
 */

package com.hehua.user.domain;

import java.util.*;

public class StatusI{
    protected long id;
    protected Date cts;
    protected Date uts;
    protected long uid;
    protected int mama_status;
    protected Date mama_birth;
    protected int baby_gender;
    protected Date baby_birth;
    
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
    
    public int getMamaStatus(){
        return mama_status;
    }
    public void setMamaStatus(int mama_status){
        this.mama_status=mama_status;
    }
    
    public Date getMamaBirth(){
        return mama_birth;
    }
    public void setMamaBirth(Date mama_birth){
        this.mama_birth=mama_birth;
    }
    
    public int getBabyGender(){
        return baby_gender;
    }
    public void setBabyGender(int baby_gender){
        this.baby_gender=baby_gender;
    }
    
    public Date getBabyBirth(){
        return baby_birth;
    }
    public void setBabyBirth(Date baby_birth){
        this.baby_birth=baby_birth;
    }
    
}
