/**
 * 
 */
package com.hehua.user.dao;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hehua.framework.dao.ReadOnlyKeyValueDAO;
import com.hehua.user.domain.Token;

/**
 * @author zhihua
 *
 */
@Component
public class TokenKeyValueDAO extends ReadOnlyKeyValueDAO<String, Token> {

    @Autowired
    private TokenDAO tokenDAO;

    @Override
    public Token get(String key) {
        return tokenDAO.getTokenByToken(key);
    }

    @Override
    public Map<String, Token> mget(Collection<String> keys) {
        throw new UnsupportedOperationException();
    }
}
