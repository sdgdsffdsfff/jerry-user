/*
 * 由系统于2014-08-01 17:00:03生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hehua.user.domain.Credential;

public interface CredentialDAOI {

    @Select("select * from `credential` where id=#{id}")
    Credential getCredentialById(long id);

    @Select("select 1 from `credential` where id=#{id}")
    Integer hasCredentialWithId(long id);

    @Select("select * from `credential` where `uid`=#{uid}")
    Credential getCredentialByUid(@Param("uid") long uid);

    @Select("select 1 from `credential` where `uid`=#{uid}")
    Integer hasCredentialWithUid(@Param("uid") long uid);

    @Select("select * from `credential`")
    List<Credential> getAllCredential();

    @Insert("INSERT INTO `credential`(`cts`,`uts`,`uid`,`pass`,`salt`) VALUES (#{cts},#{uts},#{uid},#{pass},#{salt})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int createCredential(Credential ent);

    @Update("update `credential` set `cts`=#{cts},`uts`=#{uts},`uid`=#{uid},`pass`=#{pass},`salt`=#{salt} where id=#{id}")
    int updateCredentialById(Credential ent);

    @Delete("delete from `credential` where id=#{id}")
    int deleteCredentialById(long id);

}
