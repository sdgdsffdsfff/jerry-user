/*
 * 由系统于2014-08-01 17:00:03生成。
 */

package com.hehua.user.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import com.hehua.user.domain.Credential;

@javax.inject.Named
public class CredentialService extends CredentialServiceI {

    private static final Logger log = Logger.getLogger(CredentialService.class);

    public boolean verifyPassword(long uid, String password) {
        return dao.verifyPassword(uid, password) > 0;
    }

    public boolean updatePassword(long uid, String password) {
        Credential credential = dao.getCredentialByUid(uid);
        String md5Password = DigestUtils.md5Hex(password + credential.getSalt());
        return dao.updatePassword(uid, md5Password) > 0;
    }
}
