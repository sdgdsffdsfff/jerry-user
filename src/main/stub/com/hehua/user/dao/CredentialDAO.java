/*
 * 由系统于2014-08-01 17:00:03生成。
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@javax.inject.Named
public interface CredentialDAO extends CredentialDAOI {

    @Select("select 1 from from `credential` where `uid`=#{uid} and `pass`=#{pass}")
    Integer verifyPassword(@Param("uid") long uid, @Param("pass") String pass);

    @Update("update `credential` set `pass` = #{pass} where `uid`=#{uid}")
    int updatePassword(@Param("uid") long uid, @Param("pass") String pass);
}
