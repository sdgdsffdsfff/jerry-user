/*
 * 由系统于2014-08-14 15:35:10生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.City;
import com.hehua.user.dao.CityDAO;
import java.util.*;

public class CityServiceI{

    @javax.inject.Inject
    protected CityDAO dao;

    public City getCityById(long id){
        return dao.getCityById(id);
    }
    
    public boolean hasCityWithId(long id){
        return dao.hasCityWithId(id)!=null;
    }
    
    public List<City> getAllCity(){
        return dao.getAllCity();
    }
    
    public boolean createCity(City ent){
        return dao.createCity(ent)==1;
    }
    
    public boolean updateCityById(City ent){
        return dao.updateCityById(ent)==1;
    }
    
    public boolean deleteCityById(long id){
        return dao.deleteCityById(id)==1;
    }
    
}
