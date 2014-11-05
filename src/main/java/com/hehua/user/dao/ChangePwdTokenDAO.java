/**
 * 
 */
package com.hehua.user.dao;

import javax.inject.Named;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hehua.user.model.ChangePwdToken;

/**
 * @author zhihua
 *
 */
@Named()
public interface ChangePwdTokenDAO {

    @Insert("insert into `change_pwd_token` (`uid`, `mobile`, `token`, `cts`, `uts`) values (#{uid}, #{mobile}, #{token}, #{cts}, #{uts})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(ChangePwdToken changePswToken);

    @Select("select `id`, `uid`, `mobile`, `token`, `cts`, `uts` from `change_pwd_token` where `token` = #{token}")
    public ChangePwdToken getByToken(@Param("token") String token);

    @Select("select `id`, `uid`, `mobile`, `token`, `cts`, `uts` from `change_pwd_token` where `id` = #{id}")
    public ChangePwdToken getById(@Param("id") int id);

}
