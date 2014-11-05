/*
 * 由系统于2014-08-14 15:35:10生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.Town;
import java.util.List;

public interface TownDAOI{
    @Select("select * from `town` where id=#{id}")
    Town getTownById(long id);
    
    @Select("select 1 from `town` where id=#{id}")
    Integer hasTownWithId(long id);
    
    @Select("select * from `town`")
    List<Town> getAllTown();
    
    @Insert("INSERT INTO `town`(`Name`,`Code`,`CountyID`) VALUES (#{Name},#{Code},#{CountyID})")
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    int createTown(Town ent);
    
    @Update("update `town` set `Name`=#{Name},`Code`=#{Code},`CountyID`=#{CountyID} where id=#{id}")
    int updateTownById(Town ent);
    
    @Delete("delete from `town` where id=#{id}")
    int deleteTownById(long id);
    
}
