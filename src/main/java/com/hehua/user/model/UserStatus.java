/**
 * 
 */
package com.hehua.user.model;

/**
 * @author zhihua
 *
 */
public enum UserStatus {

    Normal(0),

    Unactive(1),

    Disabled(2),

    ;

    private final int code;

    /**
     * @param code
     */
    private UserStatus(int code) {
        this.code = code;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

}
