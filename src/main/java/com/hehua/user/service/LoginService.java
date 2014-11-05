/**
 * 
 */
package com.hehua.user.service;

import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.hehua.event.EventDispatcher;
import com.hehua.framework.image.ImageService;
import com.hehua.user.domain.Baby;
import com.hehua.user.domain.Credential;
import com.hehua.user.domain.Token;
import com.hehua.user.domain.User;
import com.hehua.user.exeception.PasswordNotMatchException;
import com.hehua.user.exeception.UsernameNotFoundException;
import com.hehua.user.model.BabyView;
import com.hehua.user.model.LoginResult;

/**
 * 
 * 登陆服务
 * 
 * @author zhihua
 *
 */
@Named
public class LoginService {

    @Inject
    CaptchaService captchaService;

    @Inject
    FreshtokenService freshtokenService;

    @Inject
    CredentialService credentialService;

    @Inject
    TokenService tokenService;

    @Inject
    BabyService babyService;

    @Inject
    NameService nameService;

    @Autowired
    EventDispatcher eventDispatcher;

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserManager userManager;

    @Autowired
    private AvatarUtils avatarUtils;

    /**
     * 登录，生成token
     *
     * @param freshToken
     * @param password
     * @return
     * @throws UsernameNotFoundException
     * @throws PasswordNotMatchException
     */
    public LoginResult login(String account, String password) throws UsernameNotFoundException,
            PasswordNotMatchException {
        // 用户是否存在
        User user = userManager.getUserByMobile(account);
        if (user == null) {
            throw new UsernameNotFoundException();
        }

        // 验证密码
        Credential credential = credentialService.getCredentialByUid(user.getId());
        String md5Password = DigestUtils.md5Hex(password + credential.getSalt());
        if (!StringUtils.equals(md5Password, credential.getPass())) {
            throw new PasswordNotMatchException();
        }
        return doLogin(user);
    }

    public User loginCheck(String account, String password) throws UsernameNotFoundException,
            PasswordNotMatchException {
        // 用户是否存在
        User user = userManager.getUserByMobile(account);
        if (user == null) {
            throw new UsernameNotFoundException();
        }

        // 验证密码
        Credential credential = credentialService.getCredentialByUid(user.getId());
        String md5Password = DigestUtils.md5Hex(password + credential.getSalt());
        if (!StringUtils.equals(md5Password, credential.getPass())) {
            throw new PasswordNotMatchException();
        }
        return user;
    }

    /**
     * @param user
     * @return
     */
    public LoginResult doLogin(User user) {
        // token
        Token token = new Token();
        token.setUid(user.getId());
        token.setToken(UUID.randomUUID().toString());
        token.setCts(new Date());
        token.setUts(token.getCts());
        token.setLastlogin(token.getCts());
        tokenService.createToken(token);

        Baby baby = babyService.getOrCreateBabyByUid(user.getId());
        String avatarUrl = avatarUtils.getAvatarUrl(user.getAvatarid());
        BabyView babyView = new BabyView(baby);
        return new LoginResult(token.getToken(), user.getId(), user.getName(), avatarUrl, babyView);
    }

}
