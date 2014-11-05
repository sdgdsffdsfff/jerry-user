/*
 * 由系统于2014-10-08 15:51:26生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.Qrcode;
import java.util.List;

public interface QrcodeDAOI{
    @Select("select * from `qrcode` where id=#{id}")
    Qrcode getQrcodeById(long id);
    
    @Select("select 1 from `qrcode` where id=#{id}")
    Integer hasQrcodeWithId(long id);
    
    @Select("select * from `qrcode`")
    List<Qrcode> getAllQrcode();
    
    @Insert("INSERT INTO `qrcode`(`uid`,`uuid`,`status`,`addtime`) VALUES (#{uid},#{uuid},#{status},#{addtime})")
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    int createQrcode(Qrcode ent);
    
    @Update("update `qrcode` set `uid`=#{uid},`uuid`=#{uuid},`status`=#{status},`addtime`=#{addtime} where id=#{id}")
    int updateQrcodeById(Qrcode ent);
    
    @Delete("delete from `qrcode` where id=#{id}")
    int deleteQrcodeById(long id);
    
}
