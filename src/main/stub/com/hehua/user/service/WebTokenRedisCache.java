package com.hehua.user.service;

import com.alibaba.fastjson.JSON;
import com.hehua.framework.cache.AbstractRedisCache;
import com.hehua.framework.jedis.PoolableJedisManager;
import com.hehua.user.model.WebToken;

import javax.inject.Named;

/**
 * Created by liuweiwei on 14-10-14.
 */
@Named
public class WebTokenRedisCache extends AbstractRedisCache<String, WebToken>{

    public WebTokenRedisCache() {
        super(PoolableJedisManager.getDefaultCacheJedis());
    }

    @Override
    public String buildKey(String key) {
        return "webtoken:" + key;
    }

    @Override
    public String encode(WebToken object) {
        return JSON.toJSONString(object);
    }

    @Override
    public WebToken decode(String object) {
        return JSON.parseObject(object, WebToken.class);
    }
}
