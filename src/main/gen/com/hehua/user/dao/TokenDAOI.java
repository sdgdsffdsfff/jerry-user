/*
 * 由系统于2014-08-01 17:44:04生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.Token;
import java.util.List;

public interface TokenDAOI{
    @Select("select * from `token` where id=#{id}")
    Token getTokenById(long id);
    
    @Select("select 1 from `token` where id=#{id}")
    Integer hasTokenWithId(long id);
    
    @Select("select * from `token` where `token`=#{token}")
    Token getTokenByToken(@Param("token")String token);
    
    @Select("select 1 from `token` where `token`=#{token}")
    Integer hasTokenWithToken(@Param("token")String token);
    
    @Select("select * from `token`")
    List<Token> getAllToken();
    
    @Insert("INSERT INTO `token`(`cts`,`uts`,`uid`,`token`,`device`,`os`,`lastlogin`) VALUES (#{cts},#{uts},#{uid},#{token},#{device},#{os},#{lastlogin})")
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    int createToken(Token ent);
    
    @Update("update `token` set `cts`=#{cts},`uts`=#{uts},`uid`=#{uid},`token`=#{token},`device`=#{device},`os`=#{os},`lastlogin`=#{lastlogin} where id=#{id}")
    int updateTokenById(Token ent);
    
    @Delete("delete from `token` where id=#{id}")
    int deleteTokenById(long id);
    
}
