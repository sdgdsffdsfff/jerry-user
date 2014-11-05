/*
 * 由系统于2014-10-29 19:42:21生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.OrderRcRecord;
import java.util.List;

public interface OrderRcRecordDAOI{
    @Select("select * from `order_rc_record` where id=#{id}")
    OrderRcRecord getOrderRcRecordById(long id);
    
    @Select("select 1 from `order_rc_record` where id=#{id}")
    Integer hasOrderRcRecordWithId(long id);
    
    @Select("select * from `order_rc_record`")
    List<OrderRcRecord> getAllOrderRcRecord();
    
    @Insert("INSERT INTO `order_rc_record`(`uid`,`mobile`,`deviceid`,`clientid`,`ip`,`receiver`,`receivermobile`,`province`,`city`,`county`,`town`,`detail`,`postcode`,`itemid`,`skuid`,`quantity`) VALUES (#{uid},#{mobile},#{deviceid},#{clientid},#{ip},#{receiver},#{receivermobile},#{province},#{city},#{county},#{town},#{detail},#{postcode},#{itemid},#{skuid},#{quantity})")
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    int createOrderRcRecord(OrderRcRecord ent);
    
    @Update("update `order_rc_record` set `uid`=#{uid},`mobile`=#{mobile},`deviceid`=#{deviceid},`clientid`=#{clientid},`ip`=#{ip},`receiver`=#{receiver},`receivermobile`=#{receivermobile},`province`=#{province},`city`=#{city},`county`=#{county},`town`=#{town},`detail`=#{detail},`postcode`=#{postcode},`itemid`=#{itemid},`skuid`=#{skuid},`quantity`=#{quantity} where id=#{id}")
    int updateOrderRcRecordById(OrderRcRecord ent);
    
    @Delete("delete from `order_rc_record` where id=#{id}")
    int deleteOrderRcRecordById(long id);
    
}
