/**
 *
 */
package com.hehua.user.service;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.hehua.framework.cache.AbstractRedisCache;
import com.hehua.framework.jedis.PoolableJedisManager;
import com.hehua.user.domain.Token;

/**
 * @author zhihua
 */
@Component
public class TokenRedisCache extends AbstractRedisCache<String, Token> {

    public TokenRedisCache() {
        super(PoolableJedisManager.getDefaultCacheJedis());
    }

    @Override
    public String encode(Token object) {
        return JSON.toJSONString(object);
    }

    @Override
    public Token decode(String object) {
        return JSON.parseObject(object, Token.class);
    }

    @Override
    public String buildKey(String key) {
        return "token:" + key;
    }

}
