/*
 * 由系统于2014-08-01 17:35:56生成。
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

@javax.inject.Named
public interface TokenDAO extends TokenDAOI {

    @Delete("delete from `token` where `token`=#{token}")
    int deleteTokenByToken(@Param("token") String token);
}
