/*
 * 由系统于2014-08-01 17:35:56生成。
 */

package com.hehua.user.domain;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.hehua.commons.time.DateUtils;

public class Token extends TokenI {

    private static final long EXPIRE_TIME = TimeUnit.DAYS.toMillis(90);

    public boolean isExpired() {
        return DateUtils.intervalMillis(new Date(), getCts()) >= EXPIRE_TIME;
    }
}
