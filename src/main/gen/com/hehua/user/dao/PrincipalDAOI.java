/*
 * 由系统于2014-08-01 17:00:03生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.Principal;
import java.util.List;

public interface PrincipalDAOI{
    @Select("select * from `principal` where id=#{id}")
    Principal getPrincipalById(long id);
    
    @Select("select 1 from `principal` where id=#{id}")
    Integer hasPrincipalWithId(long id);
    
    @Select("select * from `principal` where `alias`=#{alias}")
    Principal getPrincipalByAlias(@Param("alias")String alias);
    
    @Select("select 1 from `principal` where `alias`=#{alias}")
    Integer hasPrincipalWithAlias(@Param("alias")String alias);
    
    @Select("select * from `principal`")
    List<Principal> getAllPrincipal();
    
    @Insert("INSERT INTO `principal`(`cts`,`uts`,`uid`,`alias`) VALUES (#{cts},#{uts},#{uid},#{alias})")
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    int createPrincipal(Principal ent);
    
    @Update("update `principal` set `cts`=#{cts},`uts`=#{uts},`uid`=#{uid},`alias`=#{alias} where id=#{id}")
    int updatePrincipalById(Principal ent);
    
    @Delete("delete from `principal` where id=#{id}")
    int deletePrincipalById(long id);
    
}
