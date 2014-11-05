/*
 * 由系统于2014-08-01 17:35:56生成。
 */

package com.hehua.user.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hehua.user.domain.Captcha;

@javax.inject.Named
public interface CaptchaDAO extends CaptchaDAOI {

    @Delete("delete from `captcha` where `phone`=#{phone}")
    int deleteCaptchaByPhone(@Param("phone") String phone);

    @Select("select 1 from `captcha` where `phone`=#{phone} and `captcha`=#{captcha} and `expire` &gt; #{expire}")
    Integer verifyCaptcha(@Param("phone") String phone, @Param("captcha") String captcha,
            @Param("expire") Date expire);

    @Select("select * from `captcha` where `phone`=#{phone} and `service`=#{service} and `status` = 0 order by id desc limit 1")
    Captcha getLastCaptchaByServiceAndPhone(@Param("service") String service,
            @Param("phone") String phone);

    @Select("select count(1) from `captcha` where `phone`=#{phone} and `service`=#{service} and `cts` >= #{starttime}")
    public int getCaptchaCountByServiceAndPhoneAndStartTime(@Param("service") String service,
            @Param("phone") String phone, @Param("starttime") Date starttime);

    @Update("update `captcha` set `status` = #{status} where `id` = #{id}")
    public int updateCaptchaStatus(@Param("id") int id, @Param("status") int status);

    @Update("update `captcha` set `status` = #{newstatus} where `phone`=#{phone} and `service`=#{service} and `status` = #{oldstatus}")
    public int updateCaptchaStatuses(@Param("service") String service,
            @Param("phone") String phone, @Param("oldstatus") int oldstatus,
            @Param("newstatus") int newstatus);
}
