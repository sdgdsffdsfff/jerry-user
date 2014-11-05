/*
 * 由系统于2014-08-07 15:56:07生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.Baby;
import java.util.List;

public interface BabyDAOI{
    @Select("select * from `baby` where id=#{id}")
    Baby getBabyById(long id);
    
    @Select("select 1 from `baby` where id=#{id}")
    Integer hasBabyWithId(long id);
    
    @Select("select * from `baby` where `uid`=#{uid}")
    Baby getBabyByUidxUid(@Param("uid")long uid);
    
    @Select("select 1 from `baby` where `uid`=#{uid}")
    Integer hasBabyWithUidxUid(@Param("uid")long uid);
    
    @Select("select * from `baby`")
    List<Baby> getAllBaby();
    
    @Insert("INSERT INTO `baby`(`uid`,`status`,`edc`,`gender`,`birthday`) VALUES (#{uid},#{status},#{edc},#{gender},#{birthday})")
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    int createBaby(Baby ent);
    
    @Update("update `baby` set `uid`=#{uid},`status`=#{status},`edc`=#{edc},`gender`=#{gender},`birthday`=#{birthday} where id=#{id}")
    int updateBabyById(Baby ent);
    
    @Delete("delete from `baby` where id=#{id}")
    int deleteBabyById(long id);
    
}
