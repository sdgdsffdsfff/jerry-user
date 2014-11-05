/*
 * 由系统于2014-08-01 17:35:56生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.Address;
import com.hehua.user.dao.AddressDAO;
import java.util.*;

public class AddressServiceI{

    @javax.inject.Inject
    protected AddressDAO dao;

    public Address getAddressById(long id){
        return dao.getAddressById(id);
    }
    
    public boolean hasAddressWithId(long id){
        return dao.hasAddressWithId(id)!=null;
    }
    
    public Address getAddressByUid(long uid){
        return dao.getAddressByUid(uid);
    }
    
    public boolean hasAddressWithUid(long uid){
        return dao.hasAddressWithUid(uid)!=null;
    }
    
    public List<Address> getAllAddress(){
        return dao.getAllAddress();
    }
    
    public boolean createAddress(Address ent){
        return dao.createAddress(ent)==1;
    }
    
    public boolean updateAddressById(Address ent){
        return dao.updateAddressById(ent)==1;
    }
    
    public boolean deleteAddressById(long id){
        return dao.deleteAddressById(id)==1;
    }
    
}
