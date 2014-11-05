/*
 * 由系统于2014-08-01 14:57:04生成。
 */

package com.hehua.user.domain;

import com.google.common.base.Function;

public class User extends UserI {

    public static final Function<User, Long> idExtractor = new Function<User, Long>() {

        @Override
        public Long apply(User input) {
            return input.getId();
        }
    };
}
