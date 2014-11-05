/*
 * 由系统于2014-08-01 17:56:09生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hehua.user.domain.Captcha;

public interface CaptchaDAOI {

    @Select("select * from `captcha` where id=#{id}")
    Captcha getCaptchaById(long id);

    @Select("select 1 from `captcha` where id=#{id}")
    Integer hasCaptchaWithId(long id);

    @Select("select * from `captcha` where `phone`=#{phone}")
    Captcha getCaptchaByPhone(@Param("phone") String phone);

    @Select("select 1 from `captcha` where `phone`=#{phone}")
    Integer hasCaptchaWithPhone(@Param("phone") String phone);

    @Select("select * from `captcha`")
    List<Captcha> getAllCaptcha();

    @Insert("INSERT INTO `captcha`(`cts`,`uts`,`phone`,`captcha`,`expire`,`service`,`status`) VALUES (#{cts},#{uts},#{phone},#{captcha},#{expire},#{service},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int createCaptcha(Captcha ent);

    @Update("update `captcha` set `cts`=#{cts},`uts`=#{uts},`phone`=#{phone},`captcha`=#{captcha},`expire`=#{expire},`service`=#{service},`status`=#{status} where id=#{id}")
    int updateCaptchaById(Captcha ent);

    @Delete("delete from `captcha` where id=#{id}")
    int deleteCaptchaById(long id);

}
