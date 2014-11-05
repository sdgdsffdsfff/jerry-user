/*
 * 由系统于2014-08-01 17:00:03生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.Principal;
import com.hehua.user.dao.PrincipalDAO;
import java.util.*;

public class PrincipalServiceI{

    @javax.inject.Inject
    protected PrincipalDAO dao;

    public Principal getPrincipalById(long id){
        return dao.getPrincipalById(id);
    }
    
    public boolean hasPrincipalWithId(long id){
        return dao.hasPrincipalWithId(id)!=null;
    }
    
    public Principal getPrincipalByAlias(String alias){
        return dao.getPrincipalByAlias(alias);
    }
    
    public boolean hasPrincipalWithAlias(String alias){
        return dao.hasPrincipalWithAlias(alias)!=null;
    }
    
    public List<Principal> getAllPrincipal(){
        return dao.getAllPrincipal();
    }
    
    public boolean createPrincipal(Principal ent){
        return dao.createPrincipal(ent)==1;
    }
    
    public boolean updatePrincipalById(Principal ent){
        return dao.updatePrincipalById(ent)==1;
    }
    
    public boolean deletePrincipalById(long id){
        return dao.deletePrincipalById(id)==1;
    }
    
}
