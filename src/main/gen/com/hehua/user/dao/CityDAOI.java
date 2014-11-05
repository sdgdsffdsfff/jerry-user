/*
 * 由系统于2014-08-14 15:35:10生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.City;
import java.util.List;

public interface CityDAOI{
    @Select("select * from `city` where id=#{id}")
    City getCityById(long id);
    
    @Select("select 1 from `city` where id=#{id}")
    Integer hasCityWithId(long id);
    
    @Select("select * from `city`")
    List<City> getAllCity();
    
    @Insert("INSERT INTO `city`(`Name`,`Code`,`ProvinceID`) VALUES (#{Name},#{Code},#{ProvinceID})")
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    int createCity(City ent);
    
    @Update("update `city` set `Name`=#{Name},`Code`=#{Code},`ProvinceID`=#{ProvinceID} where id=#{id}")
    int updateCityById(City ent);
    
    @Delete("delete from `city` where id=#{id}")
    int deleteCityById(long id);
    
}
