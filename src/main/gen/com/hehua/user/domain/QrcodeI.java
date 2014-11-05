/*
 * 由系统于2014-10-08 15:51:26生成，请勿人为进行任何修改！
 */

package com.hehua.user.domain;

public class QrcodeI{
    protected long id;
    protected long uid;
    protected String uuid;
    protected int status;
    protected long addtime;
    
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
    
    public long getUid(){
        return uid;
    }
    public void setUid(long uid){
        this.uid=uid;
    }
    
    public String getUuid(){
        return uuid;
    }
    public void setUuid(String uuid){
        this.uuid=uuid;
    }
    
    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status=status;
    }
    
    public long getAddtime(){
        return addtime;
    }
    public void setAddtime(long addtime){
        this.addtime=addtime;
    }
    
}
