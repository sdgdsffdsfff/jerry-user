/*
 * 由系统于2014-08-14 15:35:10生成，请勿人为进行任何修改！
 */

package com.hehua.user.domain;

import java.util.*;

public class TownI{
    protected long ID;
    protected String Name;
    protected String Code;
    protected long CountyID;
    
    public long getID(){
        return ID;
    }
    public void setID(long ID){
        this.ID=ID;
    }
    
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    
    public String getCode(){
        return Code;
    }
    public void setCode(String Code){
        this.Code=Code;
    }
    
    public long getCountyID(){
        return CountyID;
    }
    public void setCountyID(long CountyID){
        this.CountyID=CountyID;
    }
    
}
