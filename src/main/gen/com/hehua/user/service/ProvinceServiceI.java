/*
 * 由系统于2014-08-14 15:35:10生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.Province;
import com.hehua.user.dao.ProvinceDAO;
import java.util.*;

public class ProvinceServiceI{

    @javax.inject.Inject
    protected ProvinceDAO dao;

    public Province getProvinceById(long id){
        return dao.getProvinceById(id);
    }
    
    public boolean hasProvinceWithId(long id){
        return dao.hasProvinceWithId(id)!=null;
    }
    
    public List<Province> getAllProvince(){
        return dao.getAllProvince();
    }
    
    public boolean createProvince(Province ent){
        return dao.createProvince(ent)==1;
    }
    
    public boolean updateProvinceById(Province ent){
        return dao.updateProvinceById(ent)==1;
    }
    
    public boolean deleteProvinceById(long id){
        return dao.deleteProvinceById(id)==1;
    }
    
}
