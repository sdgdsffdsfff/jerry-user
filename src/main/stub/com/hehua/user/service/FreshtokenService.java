/*
 * 由系统于2014-08-01 17:35:56生成。
 */

package com.hehua.user.service;

import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.hehua.user.domain.Freshtoken;

@javax.inject.Named
public class FreshtokenService extends FreshtokenServiceI {

    private static final Logger log = Logger.getLogger(FreshtokenService.class);

    public Freshtoken getFreshToken(String fresh) {
        return dao.getFreshToken(fresh, new Date());
    }

    public Freshtoken createFreshToken(String mobile) {
        Freshtoken freshtoken = new Freshtoken();
        freshtoken.setPhone(mobile);
        freshtoken.setFreshtoken(UUID.randomUUID().toString());
        freshtoken.setCts(new Date());
        freshtoken.setUts(freshtoken.getCts());
        freshtoken.setExpire(new Date(freshtoken.getCts().getTime() + 5 * 60 * 1000));
        this.createFreshtoken(freshtoken);
        return freshtoken;
    }
}
