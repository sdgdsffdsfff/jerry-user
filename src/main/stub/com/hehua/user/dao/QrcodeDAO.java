/*
 * 由系统于2014-10-08 15:51:26生成。
 */

package com.hehua.user.dao;

import com.hehua.user.domain.Qrcode;
import org.apache.ibatis.annotations.Select;

@javax.inject.Named
public interface QrcodeDAO extends QrcodeDAOI{

    @Select("select * from `qrcode` where uuid=#{uuid}")
    Qrcode getQrcodeByUuid(String uuid);
}
