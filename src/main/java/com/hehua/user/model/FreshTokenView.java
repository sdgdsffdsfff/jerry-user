/**
 * 
 */
package com.hehua.user.model;

/**
 * @author zhihua
 *
 */
public class FreshTokenView {

    private String freshtoken;

    /**
     * @param freshtoken
     */
    public FreshTokenView(String freshtoken) {
        super();
        this.freshtoken = freshtoken;
    }

    public String getFreshtoken() {
        return freshtoken;
    }

    public void setFreshtoken(String freshtoken) {
        this.freshtoken = freshtoken;
    }

}
