/**
 * 
 */
package com.hehua.user.service;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.hehua.framework.cache.AbstractRedisCache;
import com.hehua.framework.jedis.PoolableJedisManager;
import com.hehua.user.domain.User;

/**
 * @author zhihua
 *
 */
@Component
public class UserRedisCache extends AbstractRedisCache<Long, User> {

    public UserRedisCache() {
        super(PoolableJedisManager.getDefaultCacheJedis());
    }

    @Override
    public String encode(User object) {
        return JSON.toJSONString(object);
    }

    @Override
    public User decode(String object) {
        return JSON.parseObject(object, User.class);
    }

    @Override
    public String buildKey(Long key) {
        return "user:" + key;
    }

}
