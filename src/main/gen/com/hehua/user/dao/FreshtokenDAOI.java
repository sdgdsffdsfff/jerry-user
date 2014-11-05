/*
 * 由系统于2014-08-01 17:56:09生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.Freshtoken;
import java.util.List;

public interface FreshtokenDAOI{
    @Select("select * from `freshtoken` where id=#{id}")
    Freshtoken getFreshtokenById(long id);
    
    @Select("select 1 from `freshtoken` where id=#{id}")
    Integer hasFreshtokenWithId(long id);
    
    @Select("select * from `freshtoken` where `freshtoken`=#{freshtoken}")
    Freshtoken getFreshtokenByFreshtoken(@Param("freshtoken")String freshtoken);
    
    @Select("select 1 from `freshtoken` where `freshtoken`=#{freshtoken}")
    Integer hasFreshtokenWithFreshtoken(@Param("freshtoken")String freshtoken);
    
    @Select("select * from `freshtoken`")
    List<Freshtoken> getAllFreshtoken();
    
    @Insert("INSERT INTO `freshtoken`(`cts`,`uts`,`phone`,`freshtoken`,`expire`) VALUES (#{cts},#{uts},#{phone},#{freshtoken},#{expire})")
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    int createFreshtoken(Freshtoken ent);
    
    @Update("update `freshtoken` set `cts`=#{cts},`uts`=#{uts},`phone`=#{phone},`freshtoken`=#{freshtoken},`expire`=#{expire} where id=#{id}")
    int updateFreshtokenById(Freshtoken ent);
    
    @Delete("delete from `freshtoken` where id=#{id}")
    int deleteFreshtokenById(long id);
    
}
