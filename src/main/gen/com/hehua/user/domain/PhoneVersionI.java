/*
 * 由系统于2014-08-29 13:39:17生成，请勿人为进行任何修改！
 */

package com.hehua.user.domain;

import java.util.*;

public class PhoneVersionI{
    protected long id;
    protected Date cts;
    protected Date uts;
    protected String version;
    protected String channel;
    protected String downloadurl;
    protected String releasenote;
    private int forceupdate;

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
    
    public String getVersion(){
        return version;
    }
    public void setVersion(String version){
        this.version=version;
    }
    
    public String getChannel(){
        return channel;
    }
    public void setChannel(String channel){
        this.channel=channel;
    }
    
    public String getDownloadurl(){
        return downloadurl;
    }
    public void setDownloadurl(String downloadurl){
        this.downloadurl=downloadurl;
    }
    
    public String getReleasenote(){
        return releasenote;
    }
    public void setReleasenote(String releasenote){
        this.releasenote=releasenote;
    }

    public int getForceupdate() {
        return forceupdate;
    }

    public void setForceupdate(int forceupdate) {
        this.forceupdate = forceupdate;
    }
}
