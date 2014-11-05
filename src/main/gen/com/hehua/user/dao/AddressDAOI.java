/*
 * 由系统于2014-08-14 15:26:02生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.Address;
import java.util.List;

public interface AddressDAOI{
    @Select("select * from `address` where id=#{id}")
    Address getAddressById(long id);
    
    @Select("select 1 from `address` where id=#{id}")
    Integer hasAddressWithId(long id);
    
    @Select("select * from `address` where `uid`=#{uid}")
    Address getAddressByUid(@Param("uid")long uid);
    
    @Select("select 1 from `address` where `uid`=#{uid}")
    Integer hasAddressWithUid(@Param("uid")long uid);
    
    @Select("select * from `address`")
    List<Address> getAllAddress();
    
    @Insert("INSERT INTO `address`(`cts`,`uts`,`uid`,`receiver`,`mobile`,`province`,`city`,`county`,`town`,`detail`,`postcode`,`isdefault`) VALUES (#{cts},#{uts},#{uid},#{receiver},#{mobile},#{province},#{city},#{county},#{town},#{detail},#{postcode},#{isdefault})")
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    int createAddress(Address ent);
    
    @Update("update `address` set `cts`=#{cts},`uts`=#{uts},`uid`=#{uid},`receiver`=#{receiver},`mobile`=#{mobile},`province`=#{province},`city`=#{city},`county`=#{county},`town`=#{town},`detail`=#{detail},`postcode`=#{postcode},`isdefault`=#{isdefault} where id=#{id}")
    int updateAddressById(Address ent);
    
    @Delete("delete from `address` where id=#{id}")
    int deleteAddressById(long id);
    
}
