/*
 * 由系统于2014-10-29 19:42:21生成。
 */

package com.hehua.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hehua.user.domain.OrderRcRecord;

@javax.inject.Named
public interface OrderRcRecordDAO extends OrderRcRecordDAOI {

    @Select("select * from `order_rc_record` where `itemid` = #{itemid} and `skuid` = #{skuid} and `clientid` = #{clientid}")
    public List<OrderRcRecord> getRecordsByItemIdAndSkuIdAndClientId(@Param("itemid") int itemId,
            @Param("skuid") int skuId, @Param("clientid") String clientId);

    @Select("select * from `order_rc_record` where `itemid` = #{itemid} and `skuid` = #{skuid} and `deviceid` = #{deviceid}")
    public List<OrderRcRecord> getRecordsByItemIdAndSkuIdAndDeviceId(@Param("itemid") int itemId,
            @Param("skuid") int skuId, @Param("deviceid") String deviceId);

    @Select("select * from `order_rc_record` where `itemid` = #{itemid} and `skuid` = #{skuid} and `receivermobile` = #{receivermobile}")
    public List<OrderRcRecord> getRecordsByItemIdAndSkuIdAndReceiverMobile(
            @Param("itemid") int itemId, @Param("skuid") int skuId,
            @Param("receivermobile") String receivermobile);
}
