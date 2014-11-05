/*
 * 由系统于2014-08-01 17:35:56生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.Freshtoken;
import com.hehua.user.dao.FreshtokenDAO;
import java.util.*;

public class FreshtokenServiceI{

    @javax.inject.Inject
    protected FreshtokenDAO dao;

    public Freshtoken getFreshtokenById(long id){
        return dao.getFreshtokenById(id);
    }
    
    public boolean hasFreshtokenWithId(long id){
        return dao.hasFreshtokenWithId(id)!=null;
    }
    
    public Freshtoken getFreshtokenByFreshtoken(String freshtoken){
        return dao.getFreshtokenByFreshtoken(freshtoken);
    }
    
    public boolean hasFreshtokenWithFreshtoken(String freshtoken){
        return dao.hasFreshtokenWithFreshtoken(freshtoken)!=null;
    }
    
    public List<Freshtoken> getAllFreshtoken(){
        return dao.getAllFreshtoken();
    }
    
    public boolean createFreshtoken(Freshtoken ent){
        return dao.createFreshtoken(ent)==1;
    }
    
    public boolean updateFreshtokenById(Freshtoken ent){
        return dao.updateFreshtokenById(ent)==1;
    }
    
    public boolean deleteFreshtokenById(long id){
        return dao.deleteFreshtokenById(id)==1;
    }
    
}
