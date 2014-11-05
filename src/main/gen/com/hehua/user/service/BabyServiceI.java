/*
 * 由系统于2014-08-07 15:54:15生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.Baby;
import com.hehua.user.dao.BabyDAO;
import java.util.*;

public class BabyServiceI{

    @javax.inject.Inject
    protected BabyDAO dao;

    public Baby getBabyById(long id){
        return dao.getBabyById(id);
    }
    
    public boolean hasBabyWithId(long id){
        return dao.hasBabyWithId(id)!=null;
    }
    
    public Baby getBabyByUidxUid(long uid){
        return dao.getBabyByUidxUid(uid);
    }
    
    public boolean hasBabyWithUidxUid(long uid){
        return dao.hasBabyWithUidxUid(uid)!=null;
    }
    
    public List<Baby> getAllBaby(){
        return dao.getAllBaby();
    }
    
    public boolean createBaby(Baby ent){
        return dao.createBaby(ent)==1;
    }
    
    public boolean updateBabyById(Baby ent){
        return dao.updateBabyById(ent)==1;
    }
    
    public boolean deleteBabyById(long id){
        return dao.deleteBabyById(id)==1;
    }
    
}
