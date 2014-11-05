/*
 * 由系统于2014-08-14 15:35:11生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.County;
import com.hehua.user.dao.CountyDAO;
import java.util.*;

public class CountyServiceI{

    @javax.inject.Inject
    protected CountyDAO dao;

    public County getCountyById(long id){
        return dao.getCountyById(id);
    }
    
    public boolean hasCountyWithId(long id){
        return dao.hasCountyWithId(id)!=null;
    }
    
    public List<County> getAllCounty(){
        return dao.getAllCounty();
    }
    
    public boolean createCounty(County ent){
        return dao.createCounty(ent)==1;
    }
    
    public boolean updateCountyById(County ent){
        return dao.updateCountyById(ent)==1;
    }
    
    public boolean deleteCountyById(long id){
        return dao.deleteCountyById(id)==1;
    }
    
}
