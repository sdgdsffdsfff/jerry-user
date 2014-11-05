/*
 * 由系统于2014-08-14 15:35:10生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.Province;
import java.util.List;

public interface ProvinceDAOI{
    @Select("select * from `province` where id=#{id}")
    Province getProvinceById(long id);
    
    @Select("select 1 from `province` where id=#{id}")
    Integer hasProvinceWithId(long id);
    
    @Select("select * from `province`")
    List<Province> getAllProvince();
    
    @Insert("INSERT INTO `province`(`Name`,`Code`,`CountryID`) VALUES (#{Name},#{Code},#{CountryID})")
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    int createProvince(Province ent);
    
    @Update("update `province` set `Name`=#{Name},`Code`=#{Code},`CountryID`=#{CountryID} where id=#{id}")
    int updateProvinceById(Province ent);
    
    @Delete("delete from `province` where id=#{id}")
    int deleteProvinceById(long id);
    
}
