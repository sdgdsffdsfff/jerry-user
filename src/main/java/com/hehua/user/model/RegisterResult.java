/**
 * 
 */
package com.hehua.user.model;

/**
 * @author zhihua
 *
 */
public class RegisterResult extends LoginResult {

    /**
     * @param token
     * @param name
     * @param avatar
     * @param baby
     */
    public RegisterResult(String token, long id, String name, String avatar, BabyView baby) {
        super(token, id, name, avatar, baby);
    }

}
