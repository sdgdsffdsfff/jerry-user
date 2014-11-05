/*
 * 由系统于2014-08-01 17:35:56生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.Token;
import com.hehua.user.dao.TokenDAO;
import java.util.*;

public class TokenServiceI{

    @javax.inject.Inject
    protected TokenDAO dao;

    public Token getTokenById(long id){
        return dao.getTokenById(id);
    }
    
    public boolean hasTokenWithId(long id){
        return dao.hasTokenWithId(id)!=null;
    }
    
    public Token getTokenByToken(String token){
        return dao.getTokenByToken(token);
    }
    
    public boolean hasTokenWithToken(String token){
        return dao.hasTokenWithToken(token)!=null;
    }
    
    public List<Token> getAllToken(){
        return dao.getAllToken();
    }
    
    public boolean createToken(Token ent){
        return dao.createToken(ent)==1;
    }
    
    public boolean updateTokenById(Token ent){
        return dao.updateTokenById(ent)==1;
    }
    
    public boolean deleteTokenById(long id){
        return dao.deleteTokenById(id)==1;
    }
    
}
