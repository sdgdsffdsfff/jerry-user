/*
 * 由系统于2014-08-01 14:57:04生成。
 */

package com.hehua.user.service;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.hehua.commons.model.CommonMetaCode;
import com.hehua.commons.model.ResultView;
import com.hehua.event.EventDispatcher;
import com.hehua.framework.antispam.AntispamResult;
import com.hehua.framework.antispam.AntispamService;
import com.hehua.framework.image.ImageService;
import com.hehua.user.dao.UserDAO;
import com.hehua.user.domain.ReservedWord;
import com.hehua.user.domain.User;
import com.hehua.user.exeception.InvalidNicknameException;
import com.hehua.user.exeception.NickNameAlreadyExistException;
import com.hehua.user.exeception.NickNameIllegalException;

@javax.inject.Named
public class UserService {

    private static final Logger log = Logger.getLogger(UserService.class);

    @Autowired
    private UserDAO userDAO;

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
    private ReservedWordService reservedWordService;

    @Autowired
    private AntispamService antispamService;

    public List<User> getUserListByIds(Collection<Long> ids) {
        if (ids == null || ids.size() == 0)
            return null;
        return userDAO.mgetUserListByIds(ids);
    }

    public String updateNickname(long uid, String nickname) throws InvalidNicknameException,
            NickNameAlreadyExistException, NickNameIllegalException {
        if (!isValidNickname(nickname)) {
            throw new InvalidNicknameException();
        }

        if (userManager.existNickName(nickname)) {
            throw new NickNameAlreadyExistException();
        }

        if (reservedWordService.existWordAndType(nickname, ReservedWord.TYPE_NICKNAME)) {
            throw new NickNameIllegalException();
        }

        AntispamResult inspectResult = antispamService.inspect(nickname);
        if (!inspectResult.isSafe()) {
            throw new InvalidNicknameException();
        }

        userManager.updateNickname(uid, nickname);
        return nickname;
    }

    public boolean isValidNickname(String nickname) {
        nickname = normalizeNickname(nickname);
        // 中间不允许有空格
        if (StringUtils.isEmpty(nickname)) {
            return false;
        }

        return com.hehua.commons.lang.StringUtils.getChineseLength(nickname) <= 16;
    }

    public String normalizeNickname(String nickname) {
        return StringUtils.trim(nickname);
    }

    public ResultView<List<User>> getDarenList() {
        List<User> userList = this.userDAO.getDarenList();
        return new ResultView<List<User>>(CommonMetaCode.Success, userList);
    }

    public User findUserById(long id){
        return userDAO.getUserById(id);
    }
    public User findUserByAccount(String  account){
        return userDAO.getUserByAccount(account);
    }

    public int updateDarenState(long uid,int daren){
        return userDAO.updateDarenState(uid,daren);
    }
}
