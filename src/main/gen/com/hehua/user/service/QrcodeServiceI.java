/*
 * 由系统于2014-10-08 15:51:25生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.Qrcode;
import com.hehua.user.dao.QrcodeDAO;
import java.util.*;

public class QrcodeServiceI{

    @javax.inject.Inject
    protected QrcodeDAO dao;

    public Qrcode getQrcodeById(long id){
        return dao.getQrcodeById(id);
    }
    
    public boolean hasQrcodeWithId(long id){
        return dao.hasQrcodeWithId(id)!=null;
    }
    
    public List<Qrcode> getAllQrcode(){
        return dao.getAllQrcode();
    }
    
    public boolean createQrcode(Qrcode ent){
        return dao.createQrcode(ent)==1;
    }
    
    public boolean updateQrcodeById(Qrcode ent){
        return dao.updateQrcodeById(ent)==1;
    }
    
    public boolean deleteQrcodeById(long id){
        return dao.deleteQrcodeById(id)==1;
    }
    
}
