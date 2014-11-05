/*
 * 由系统于2014-08-01 17:35:56生成。
 */

package com.hehua.user.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.hehua.framework.dao.DAOUtils;
import com.hehua.framework.dao.MultilayerKeyValueDAO;
import com.hehua.user.dao.TokenKeyValueDAO;
import com.hehua.user.domain.Token;

@javax.inject.Named
public class TokenService extends TokenServiceI implements InitializingBean {

    private static final Logger log = Logger.getLogger(TokenService.class);

    @Autowired
    private TokenKeyValueDAO tokenKeyValueDAO;

    @Autowired
    private TokenRedisCache tokenRedisCache;

    private MultilayerKeyValueDAO<String, Token> tokenMulDAO;

    @Override
    public void afterPropertiesSet() throws Exception {
        tokenMulDAO = DAOUtils.multiDAO(tokenRedisCache, tokenKeyValueDAO);
    }

    public Long verfiyToken(String tokenStr) {
        Token token = getTokenByToken(tokenStr);
        if (token == null) {
            return null;
        }

        if (token.isExpired()) {
            this.deleteTokenByToken(token.getToken());
            return null;
        }
        return token.getUid();
    }

    @Override
    public boolean createToken(Token ent) {
        boolean result = super.createToken(ent);
        if (result) {
            tokenMulDAO.set(ent.getToken(), ent);
        }
        return result;
    }

    public boolean deleteTokenByToken(String token) {
        dao.deleteTokenByToken(token);
        tokenMulDAO.del(token);
        return true;
    }

    @Override
    public Token getTokenByToken(String token) {
        return tokenMulDAO.get(token);
    }

}
