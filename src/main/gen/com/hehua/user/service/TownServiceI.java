/*
 * 由系统于2014-08-14 15:35:10生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.Town;
import com.hehua.user.dao.TownDAO;
import java.util.*;

public class TownServiceI{

    @javax.inject.Inject
    protected TownDAO dao;

    public Town getTownById(long id){
        return dao.getTownById(id);
    }
    
    public boolean hasTownWithId(long id){
        return dao.hasTownWithId(id)!=null;
    }
    
    public List<Town> getAllTown(){
        return dao.getAllTown();
    }
    
    public boolean createTown(Town ent){
        return dao.createTown(ent)==1;
    }
    
    public boolean updateTownById(Town ent){
        return dao.updateTownById(ent)==1;
    }
    
    public boolean deleteTownById(long id){
        return dao.deleteTownById(id)==1;
    }
    
}
