/*
 * 由系统于2014-08-29 13:39:17生成。
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.PhoneVersion;

import java.util.List;

@javax.inject.Named
public interface PhoneVersionDAO extends PhoneVersionDAOI {
    @Select("select * from `phone_version` where channel=#{channel}")
    List<PhoneVersion> getPhoneVersionByChannel(@Param("channel") String channel);

    @Select("select * from `phone_version` where channel=#{channel} and version=#{version} limit 1")
    PhoneVersion getPhoneVersionBy(@Param("version") String version, @Param("channel") String channel);

    @Update("update `phone_version` set `forceupdate`=#{forceupdate} where id=#{id}")
    int updatePhoneVersionByIdAndForceUpdate(@Param("id") int id, @Param("forceupdate") int forceupdate);
}
