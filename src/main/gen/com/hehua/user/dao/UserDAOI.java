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

import com.hehua.user.domain.User;

public interface UserDAOI {

    @Select("select * from `user` where id=#{id}")
    User getUserById(long id);

    @Select("select * from `user` where id=#{id} limit #{offset},#{limit}")
    User getUserByIdAndPage(@Param("id") Long id, @Param("offset") int offset,
            @Param("limit") int limit);

    @Select("select count(`id`) from `user` where id=#{id}")
    Integer getCountUserByIdAndPage(@Param("id") Long id);

    @Select("select 1 from `user` where id=#{id}")
    Integer hasUserWithId(long id);

    @Select("select * from `user` where `account`=#{account}")
    User getUserByAccount(@Param("account") String account);

    @Select("select * from `user` where `account`=#{account} limit #{offset},#{limit}")
    User getUserByAccountByPage(@Param("account") String account, @Param("offset") int offset,
            @Param("limit") int limit);

    @Select("select count(`id`) from `user` where `account`=#{account}")
    Integer getCountUserByAccountByPage(@Param("account") String account);

    @Select("select 1 from `user` where `account`=#{account}")
    Integer hasUserWithAccount(@Param("account") String account);

    @Select("select * from `user`")
    List<User> getAllUser();

    @Select("select * from `user` order by `id` desc limit #{offset},#{limit} ")
    List<User> getAllUserByPage(@Param("offset") int offset, @Param("limit") int limit);

    @Select("select count(`id`) from `user`")
    Integer getAllCount();

    @Insert("INSERT INTO `user`(`cts`,`uts`,`account`,`name`,`desc`,`avatar`,`avatarid`,`daren`) VALUES (#{cts},#{uts},#{account},#{name},#{desc},#{avatar},#{avatarid},#{daren})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int createUser(User ent);

    @Update("update `user` set `cts`=#{cts},`uts`=#{uts},`account`=#{account},`name`=#{name},`desc`=#{desc},`avatar`=#{avatar},`avatarid`=#{avatarid},`daren`=#{daren} where id=#{id}")
    int updateUserById(User ent);

    @Delete("delete from `user` where id=#{id}")
    int deleteUserById(long id);

}
