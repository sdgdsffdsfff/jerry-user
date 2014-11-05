/*
 * 由系统于2014-08-01 17:35:56生成。
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.Freshtoken;

import java.util.Date;

@javax.inject.Named
public interface FreshtokenDAO extends FreshtokenDAOI{

    @Select("select * from `freshtoken` where `freshtoken`=#{freshtoken} and `expire` &gt; #{expire}")
    Freshtoken getFreshToken(@Param("freshtoken")String freshtoken, @Param("expire") Date expire);

}
