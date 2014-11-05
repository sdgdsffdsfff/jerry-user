/*
 * 由系统于2014-08-01 17:35:56生成。
 */

package com.hehua.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hehua.user.domain.Address;

@javax.inject.Named
public interface AddressDAO extends AddressDAOI {

    @Select("select * from `address` where `uid`=#{uid}")
    List<Address> getAddressListByUid(@Param("uid") long uid);

    @Select("select * from `address` where `uid`=#{uid} and `isdefault` = 1 limit 1")
    public Address getDefaultAddressByUid(@Param("uid") long uid);

    @Select("select * from `address` where `uid`=#{uid} order by id desc limit 1")
    public Address getRecentAddressByUid(@Param("uid") long uid);

    @Select("select count(`id`) from `address` where `uid`=#{uid}")
    public int countAddresses(@Param("uid") long uid);

    @Update("update `address` set `isdefault` = #{isdefault} where `id`=#{id}")
    public void updateDefault(@Param("id") int id, @Param("isdefault") boolean isdefault);

    @Update("update `address` set `isdefault` = 0 where `uid`=#{uid} and `isdefault` = 1")
    public void removeDefault(@Param("uid") long uid);

}
