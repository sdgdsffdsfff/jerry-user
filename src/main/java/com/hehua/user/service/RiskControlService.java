/**
 * 
 */
package com.hehua.user.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hehua.user.dao.OrderRcRecordDAO;
import com.hehua.user.domain.OrderRcRecord;

/**
 * @author zhihua
 *
 */
@Service
public class RiskControlService {

    @Autowired
    private OrderRcRecordDAO orderRcRecordDAO;

    public void addOrderRecord(OrderRcRecord orderRcRecord) {
        orderRcRecordDAO.createOrderRcRecord(orderRcRecord);
    }

    public RiskLevel getRiskLevel(int itemId, int skuId, String receiverMobile, String clientId,
            String deviceId) {

        // 同一个商品，相同一个收货手机号的订单过多，不超过2个，拒绝
        // 同一个商品，相同一个设备编号，不能超过2个
        // 同一个商品，相同clientid，不能超过两个
        if (StringUtils.isNotBlank(clientId)) {
            List<OrderRcRecord> recordsByItemIdAndSkuIdAndClientId = orderRcRecordDAO
                    .getRecordsByItemIdAndSkuIdAndClientId(itemId, skuId, clientId);

            if (recordsByItemIdAndSkuIdAndClientId.size() >= 5) {
                return RiskLevel.Danger;
            }
        }

        if (StringUtils.isNotBlank(deviceId)) {
            List<OrderRcRecord> recordsByItemIdAndSkuIdAndDeviceId = orderRcRecordDAO
                    .getRecordsByItemIdAndSkuIdAndDeviceId(itemId, skuId, deviceId);

            if (recordsByItemIdAndSkuIdAndDeviceId.size() >= 5) {
                return RiskLevel.Danger;
            }
        }

        List<OrderRcRecord> recordsByItemIdAndSkuIdAndReceiverMobile = orderRcRecordDAO
                .getRecordsByItemIdAndSkuIdAndReceiverMobile(itemId, skuId, receiverMobile);

        if (recordsByItemIdAndSkuIdAndReceiverMobile.size() >= 5) {
            return RiskLevel.Danger;
        }

        return RiskLevel.Safe;
    }

}
