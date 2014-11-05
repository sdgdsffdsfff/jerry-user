/**
 * 
 */
package com.hehua.user.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hehua.framework.dao.DAOUtils;
import com.hehua.framework.dao.MultilayerKeyValueDAO;
import com.hehua.user.dao.CredentialDAO;
import com.hehua.user.dao.UserDAO;
import com.hehua.user.dao.UserKeyValueDAO;
import com.hehua.user.domain.User;

/**
 * @author zhihua
 *
 */
@Component
public class UserManager implements InitializingBean {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CredentialDAO credentialDAO;

    @Autowired
    private UserRedisCache userCacheById;

    @Autowired
    private UserKeyValueDAO userKeyValueDAOById;

    private MultilayerKeyValueDAO<Long, User> userMultiDAOById;

    @Override
    public void afterPropertiesSet() throws Exception {
        userMultiDAOById = DAOUtils.multiDAO(userCacheById, userKeyValueDAOById);
    }

    public boolean createUser(User user) {
        boolean result = userDAO.createUser(user) > 0;
        if (result) {
            userMultiDAOById.set(user.getId(), user);
        }
        return result;
    }

    public boolean existMobile(String mobile) {
        return userDAO.hasUserWithAccount(mobile) != null;
    }

    public boolean existNickName(String nickname) {
        return userDAO.hasUserWithName(nickname) != null;
    }

    public User getUserByMobile(String mobile) {
        return userDAO.getUserByAccount(mobile);
    }

    public User getUserById(long uid) {
        return userMultiDAOById.get(uid);
    }

    public Map<Long, User> getUsersByIds(Collection<Long> uids) {
        return userMultiDAOById.mget(uids);
    }

    public void updateNickname(long uid, String nickname) {

        User user = getUserById(uid);
        user.setName(nickname);
        this.userDAO.updateNickname(user.getId(), user.getName());
        userMultiDAOById.set(user.getId(), user);
    }

}
