/**
 * 
 */
package com.hehua.user.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hehua.commons.Transformers;
import com.hehua.framework.dao.ReadOnlyKeyValueDAO;
import com.hehua.user.domain.User;

/**
 * @author zhihua
 *
 */
@Component
public class UserKeyValueDAO extends ReadOnlyKeyValueDAO<Long, User> {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User get(Long key) {
        return userDAO.getUserById(key);
    }

    @Override
    public Map<Long, User> mget(Collection<Long> keys) {
        if (org.apache.commons.collections.CollectionUtils.isEmpty(keys)) {
            return Collections.emptyMap();
        }

        List<User> users = userDAO.mgetUserListByIds(keys);
        return Transformers.transformAsOneToOneMap(users, User.idExtractor);
    }

}
