/*
 * 由系统于2014-08-07 15:49:14生成。
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.Update;

import com.hehua.user.domain.Baby;

@javax.inject.Named
public interface BabyDAO extends BabyDAOI {

    @Update("update `baby` set `status`=#{status},`edc`=#{edc},`gender`=#{gender},`birthday`=#{birthday} where uid=#{uid}")
    int updateBabyByUid(Baby ent);
}
