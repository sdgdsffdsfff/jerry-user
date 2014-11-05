/*
 * 由系统于2014-08-14 15:35:11生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.County;
import java.util.List;

public interface CountyDAOI{
    @Select("select * from `county` where id=#{id}")
    County getCountyById(long id);
    
    @Select("select 1 from `county` where id=#{id}")
    Integer hasCountyWithId(long id);
    
    @Select("select * from `county`")
    List<County> getAllCounty();
    
    @Insert("INSERT INTO `county`(`Name`,`Code`,`CityID`) VALUES (#{Name},#{Code},#{CityID})")
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    int createCounty(County ent);
    
    @Update("update `county` set `Name`=#{Name},`Code`=#{Code},`CityID`=#{CityID} where id=#{id}")
    int updateCountyById(County ent);
    
    @Delete("delete from `county` where id=#{id}")
    int deleteCountyById(long id);
    
}
