/*
 * 由系统于2014-08-01 17:35:56生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.Status;
import com.hehua.user.dao.StatusDAO;
import java.util.*;

public class StatusServiceI{

    @javax.inject.Inject
    protected StatusDAO dao;

    public Status getStatusById(long id){
        return dao.getStatusById(id);
    }
    
    public boolean hasStatusWithId(long id){
        return dao.hasStatusWithId(id)!=null;
    }
    
    public Status getStatusByUid(long uid){
        return dao.getStatusByUid(uid);
    }
    
    public boolean hasStatusWithUid(long uid){
        return dao.hasStatusWithUid(uid)!=null;
    }
    
    public List<Status> getAllStatus(){
        return dao.getAllStatus();
    }
    
    public boolean createStatus(Status ent){
        return dao.createStatus(ent)==1;
    }
    
    public boolean updateStatusById(Status ent){
        return dao.updateStatusById(ent)==1;
    }
    
    public boolean deleteStatusById(long id){
        return dao.deleteStatusById(id)==1;
    }
    
}
