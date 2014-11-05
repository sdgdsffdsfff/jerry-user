/**
 * 
 */
package com.hehua.user.service;

import java.util.Date;
import java.util.UUID;

import javax.inject.Named;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hehua.commons.NormalizeUtils;
import com.hehua.commons.ValidationUtils;
import com.hehua.framework.image.ImageService;
import com.hehua.user.domain.Baby;
import com.hehua.user.domain.Captcha;
import com.hehua.user.domain.Credential;
import com.hehua.user.domain.Freshtoken;
import com.hehua.user.domain.Token;
import com.hehua.user.domain.User;
import com.hehua.user.exeception.CaptchaExpiredException;
import com.hehua.user.exeception.CaptchaNotMatchException;
import com.hehua.user.exeception.CaptchaTooFastException;
import com.hehua.user.exeception.CaptchaTooManyException;
import com.hehua.user.exeception.FreshTokenNotFoundException;
import com.hehua.user.exeception.InvalidCaptchaException;
import com.hehua.user.exeception.InvalidMobileException;
import com.hehua.user.exeception.InvalidPasswordException;
import com.hehua.user.exeception.MobileAlreadyBindedException;
import com.hehua.user.model.BabyView;
import com.hehua.user.model.RegisterResult;

/**
 * 注册服务
 * 
 * @author zhihua
 */
@Named
public class RegisterService {

    private static final Log logger = LogFactory.getLog(RegisterService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private UserManager userManager;

    @Autowired
    private FreshtokenService freshtokenService;

    @Autowired
    private BabyService babyService;

    @Autowired
    private NameService nameService;

    @Autowired
    private CredentialService credentialService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private AvatarUtils avatarUtils;

    /**
     * 注册
     *
     * @param freshToken
     * @param password
     * @return
     * @throws MobileAlreadyBindedException
     * @throws FreshTokenNotFoundException
     * @throws InvalidPasswordException
     */
    public RegisterResult register(String freshToken, String password, BabyView baby)
            throws MobileAlreadyBindedException, FreshTokenNotFoundException,
            InvalidPasswordException {
        Freshtoken freshtoken = freshtokenService.getFreshToken(freshToken);
        if (freshtoken == null) {
            throw new FreshTokenNotFoundException();
        }

        return registerInternal(freshtoken.getPhone(), null, password, baby);
    }

    public RegisterResult registerUser(String mobile, String userName, String password) {
        try {
            return registerInternal(mobile, userName, password, new BabyView());
        } catch (MobileAlreadyBindedException e) {
            logger.error("手机号码已经注册");
            return null;
        } catch (InvalidPasswordException e) {
            logger.error("密码为空");
            return null;
        }
    }

    private RegisterResult registerInternal(String mobile, String userName, String password,
            BabyView babyParams) throws MobileAlreadyBindedException, InvalidPasswordException {
        // 用户是否存在
        if (userManager.getUserByMobile(mobile) != null) {
            throw new MobileAlreadyBindedException();
        }

        if (StringUtils.isEmpty(password)) {
            throw new InvalidPasswordException();
        }

        if (!babyService.validateBabyParams(babyParams)) {
            babyParams = new BabyView();
        }

        // 用户
        User user = new User();
        user.setAccount(mobile);
        user.setCts(new Date());
        user.setUts(user.getCts());
        user.setName(StringUtils.isNotEmpty(userName) ? userName : nameService.generateRandomName());
        user.setAvatarid(0);

        if (!userManager.createUser(user)) {
            throw new MobileAlreadyBindedException();
        }

        // 密码
        String salt = RandomStringUtils.randomNumeric(10);
        String md5Password = DigestUtils.md5Hex(password + salt);

        Credential credential = new Credential();
        credential.setUid(user.getId());
        credential.setCts(new Date());
        credential.setUts(credential.getCts());
        credential.setPass(md5Password);
        credential.setSalt(salt);

        credentialService.createCredential(credential);

        // 创建baby
        Baby baby;
        if (babyParams == null) {
            baby = new Baby();
        } else {
            baby = new Baby(babyParams);
        }

        baby.setUid(user.getId());
        babyService.createBaby(baby);

        // token
        Token token = new Token();
        token.setUid(user.getId());
        token.setToken(UUID.randomUUID().toString());
        token.setCts(new Date());
        token.setUts(token.getCts());
        token.setLastlogin(token.getCts());
        tokenService.createToken(token);

        String avatarUrl = avatarUtils.getAvatarUrl(user.getAvatarid());

        return new RegisterResult(token.getToken(), user.getId(), user.getName(), avatarUrl,
                new BabyView(baby));
    }

    public void sendRegisterCaptcha(String mobile) throws InvalidMobileException,
            MobileAlreadyBindedException, CaptchaTooFastException, CaptchaTooManyException {
        mobile = NormalizeUtils.normalizeMobile(mobile);

        // 验证手机号是否合法
        if (!ValidationUtils.isValidMobile(mobile)) {
            throw new InvalidMobileException();
        }

        if (userManager.existMobile(mobile)) {
            throw new MobileAlreadyBindedException();
        }
        captchaService.sendCaptcha(Captcha.SERVICE_REGISTER, mobile);
    }

    public void verifyRegisterCaptcha(String mobile, String captcha) throws InvalidMobileException,
            CaptchaExpiredException, CaptchaNotMatchException, InvalidCaptchaException {
        captchaService.checkCaptcha(Captcha.SERVICE_REGISTER, mobile, captcha);
    }

    public Freshtoken generateFreshtoken(String mobile) {
        return freshtokenService.createFreshToken(mobile);
    }

}
