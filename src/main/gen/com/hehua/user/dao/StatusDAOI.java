/*
 * 由系统于2014-08-01 17:35:56生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.Status;
import java.util.List;

public interface StatusDAOI{
    @Select("select * from `status` where id=#{id}")
    Status getStatusById(long id);
    
    @Select("select 1 from `status` where id=#{id}")
    Integer hasStatusWithId(long id);
    
    @Select("select * from `status` where `uid`=#{uid}")
    Status getStatusByUid(@Param("uid")long uid);
    
    @Select("select 1 from `status` where `uid`=#{uid}")
    Integer hasStatusWithUid(@Param("uid")long uid);
    
    @Select("select * from `status`")
    List<Status> getAllStatus();
    
    @Insert("INSERT INTO `status`(`cts`,`uts`,`uid`,`mama_status`,`mama_birth`,`baby_gender`,`baby_birth`) VALUES (#{cts},#{uts},#{uid},#{mama_status},#{mama_birth},#{baby_gender},#{baby_birth})")
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    int createStatus(Status ent);
    
    @Update("update `status` set `cts`=#{cts},`uts`=#{uts},`uid`=#{uid},`mama_status`=#{mama_status},`mama_birth`=#{mama_birth},`baby_gender`=#{baby_gender},`baby_birth`=#{baby_birth} where id=#{id}")
    int updateStatusById(Status ent);
    
    @Delete("delete from `status` where id=#{id}")
    int deleteStatusById(long id);
    
}
