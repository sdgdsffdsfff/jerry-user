/*
 * 由系统于2014-08-01 14:57:04生成。
 */

package com.hehua.user.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hehua.user.domain.User;

@javax.inject.Named
public interface UserDAO extends UserDAOI {

    @Update("update `user` set `name` = #{name} where `id` = #{uid}")
    public int updateNickname(@Param("uid") long uid, @Param("name") String nickname);

    @Update("update `user` set `daren` = #{daren} where `id` = #{uid}")
    public int updateDarenState(@Param("uid") long uid, @Param("daren") int daren);

    @Select("select * from `user` where `daren` = 1")
    public List<User> getDarenList();

    @Select("select * from `user` where daren=1")
    List<User> getDarenUserd();

    @Select("select 1 from `user` where name=#{name}")
    Integer hasUserWithName(String name);

    public List<User> mgetUserListByIds(@Param("ids") Collection<Long> ids);
}
