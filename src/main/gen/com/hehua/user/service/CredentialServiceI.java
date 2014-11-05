/*
 * 由系统于2014-08-01 17:00:03生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.Credential;
import com.hehua.user.dao.CredentialDAO;
import java.util.*;

public class CredentialServiceI{

    @javax.inject.Inject
    protected CredentialDAO dao;

    public Credential getCredentialById(long id){
        return dao.getCredentialById(id);
    }
    
    public boolean hasCredentialWithId(long id){
        return dao.hasCredentialWithId(id)!=null;
    }
    
    public Credential getCredentialByUid(long uid){
        return dao.getCredentialByUid(uid);
    }
    
    public boolean hasCredentialWithUid(long uid){
        return dao.hasCredentialWithUid(uid)!=null;
    }
    
    public List<Credential> getAllCredential(){
        return dao.getAllCredential();
    }
    
    public boolean createCredential(Credential ent){
        return dao.createCredential(ent)==1;
    }
    
    public boolean updateCredentialById(Credential ent){
        return dao.updateCredentialById(ent)==1;
    }
    
    public boolean deleteCredentialById(long id){
        return dao.deleteCredentialById(id)==1;
    }
    
}
