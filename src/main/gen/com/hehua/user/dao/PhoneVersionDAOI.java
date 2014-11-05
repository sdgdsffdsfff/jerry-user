/*
 * 由系统于2014-08-29 13:39:17生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.PhoneVersion;
import java.util.List;

public interface PhoneVersionDAOI{
    @Select("select * from `phone_version` where id=#{id}")
    PhoneVersion getPhoneVersionById(long id);
    
    @Select("select 1 from `phone_version` where id=#{id}")
    Integer hasPhoneVersionWithId(long id);
    
    @Select("select * from `phone_version`")
    List<PhoneVersion> getAllPhoneVersion();
    
    @Insert("INSERT INTO `phone_version`(`cts`,`uts`,`version`,`channel`,`downloadurl`,`releasenote`,`forceupdate`) VALUES (#{cts},#{uts},#{version},#{channel},#{downloadurl},#{releasenote},#{forceupdate})")
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    int createPhoneVersion(PhoneVersion ent);
    
    @Update("update `phone_version` set `cts`=#{cts},`uts`=#{uts},`version`=#{version},`channel`=#{channel},`downloadurl`=#{downloadurl},`releasenote`=#{releasenote},`forceupdate`=#{forceupdate} where id=#{id}")
    int updatePhoneVersionById(PhoneVersion ent);
    
    @Delete("delete from `phone_version` where id=#{id}")
    int deletePhoneVersionById(long id);


    @Select("select * from `phone_version` order by id desc  limit #{start},#{size} ")
    List<PhoneVersion> getPhoneVersionByPage(@Param(value = "start") int start, @Param(value = "size") int size);

    @Select("select count(id) from `phone_version`")
    int getPhoneVersionCount();
    
}
