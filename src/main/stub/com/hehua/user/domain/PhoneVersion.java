/*
 * 由系统于2014-08-29 13:40:51生成。
 */

package com.hehua.user.domain;

import com.google.common.base.Function;

public class PhoneVersion extends PhoneVersionI{
    public static final Function EXE_IDX = new Function<PhoneVersion, Long>() {
        @Override
        public Long apply(PhoneVersion phoneVersion) {
            return phoneVersion.getId();
        }
    };

    public static final Function EXEACT_VERSION = new Function<PhoneVersion, String>() {
        @Override
        public String apply(PhoneVersion phoneVersion) {
            return phoneVersion.getVersion();
        }
    };


    public String toString() {
        return String.format("version=%s,forceUpdate=%d,channel=%s",this.version, this.getForceupdate(), this.channel);
    }
}
