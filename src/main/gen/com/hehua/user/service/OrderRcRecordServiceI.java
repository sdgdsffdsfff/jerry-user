/*
 * 由系统于2014-10-29 19:42:21生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.OrderRcRecord;
import com.hehua.user.dao.OrderRcRecordDAO;
import java.util.*;

public class OrderRcRecordServiceI{

    @javax.inject.Inject
    protected OrderRcRecordDAO dao;

    public OrderRcRecord getOrderRcRecordById(long id){
        return dao.getOrderRcRecordById(id);
    }
    
    public boolean hasOrderRcRecordWithId(long id){
        return dao.hasOrderRcRecordWithId(id)!=null;
    }
    
    public List<OrderRcRecord> getAllOrderRcRecord(){
        return dao.getAllOrderRcRecord();
    }
    
    public boolean createOrderRcRecord(OrderRcRecord ent){
        return dao.createOrderRcRecord(ent)==1;
    }
    
    public boolean updateOrderRcRecordById(OrderRcRecord ent){
        return dao.updateOrderRcRecordById(ent)==1;
    }
    
    public boolean deleteOrderRcRecordById(long id){
        return dao.deleteOrderRcRecordById(id)==1;
    }
    
}
