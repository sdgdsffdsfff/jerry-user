package com.hehua.user.service;

import com.hehua.user.model.WebToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.UUID;

/**
 * Created by liuweiwei on 14-10-14.
 * 网页token服务
 */
@Named
public class WebTokenService {

    @Inject
    private WebTokenRedisCache webTokenRedisCache;

    public WebToken createToken(long uid) {
        WebToken webToken = new WebToken();
        webToken.setToken(UUID.randomUUID().toString());
        webToken.setUid(uid);
        webToken.setUts(new Date());

        webTokenRedisCache.set(webToken.getToken(), webToken);
        return webToken;
    }

    public WebToken getToken(String token) {
        return webTokenRedisCache.get(token);
    }

    public void deleteToken(String token) {
        webTokenRedisCache.del(token);
    }
}
