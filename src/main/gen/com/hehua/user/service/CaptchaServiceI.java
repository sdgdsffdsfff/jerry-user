/*
 * 由系统于2014-08-01 17:56:09生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.Captcha;
import com.hehua.user.dao.CaptchaDAO;
import java.util.*;

public class CaptchaServiceI{

    @javax.inject.Inject
    protected CaptchaDAO dao;

    public Captcha getCaptchaById(long id){
        return dao.getCaptchaById(id);
    }
    
    public boolean hasCaptchaWithId(long id){
        return dao.hasCaptchaWithId(id)!=null;
    }
    
    public Captcha getCaptchaByPhone(String phone){
        return dao.getCaptchaByPhone(phone);
    }
    
    public boolean hasCaptchaWithPhone(String phone){
        return dao.hasCaptchaWithPhone(phone)!=null;
    }
    
    public List<Captcha> getAllCaptcha(){
        return dao.getAllCaptcha();
    }
    
    public boolean createCaptcha(Captcha ent){
        return dao.createCaptcha(ent)==1;
    }
    
    public boolean updateCaptchaById(Captcha ent){
        return dao.updateCaptchaById(ent)==1;
    }
    
    public boolean deleteCaptchaById(long id){
        return dao.deleteCaptchaById(id)==1;
    }
    
}
