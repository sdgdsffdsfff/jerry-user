/**
 * 
 */
package com.hehua.user.model;

/**
 * @author zhihua
 *
 */
public class LoginResult {

    private String token;

    private long id;

    private String name;

    private String avatar;

    private BabyView baby;

    /**
     * @param token
     * @param name
     * @param avatar
     * @param baby
     */
    public LoginResult(String token, long id, String name, String avatar, BabyView baby) {
        super();
        this.id = id;
        this.token = token;
        this.name = name;
        this.avatar = avatar;
        this.baby = baby;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public BabyView getBaby() {
        return baby;
    }

    public void setBaby(BabyView baby) {
        this.baby = baby;
    }

}
