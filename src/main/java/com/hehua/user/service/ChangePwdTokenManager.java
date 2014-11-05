/**
 * 
 */
package com.hehua.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hehua.user.dao.ChangePwdTokenDAO;
import com.hehua.user.model.ChangePwdToken;

/**
 * @author zhihua
 *
 */
@Component
public class ChangePwdTokenManager {

    @Autowired
    private ChangePwdTokenDAO changePwdTokenDAO;

    public ChangePwdToken getChangePwdTokenByToken(String token) {
        return changePwdTokenDAO.getByToken(token);
    }

    public void addChangePwdToken(ChangePwdToken changePwdToken) {
        changePwdTokenDAO.insert(changePwdToken);
    }
}
