/*
 * 由系统于2014-08-29 13:39:17生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import java.util.Date;
import java.util.List;

import com.hehua.user.dao.PhoneVersionDAO;
import com.hehua.user.domain.PhoneVersion;
import org.apache.commons.lang.StringUtils;

public class PhoneVersionServiceI {

    @javax.inject.Inject
    protected PhoneVersionDAO dao;

    public PhoneVersion getPhoneVersionById(long id) {
        return dao.getPhoneVersionById(id);
    }

    public boolean hasPhoneVersionWithId(long id) {
        return dao.hasPhoneVersionWithId(id) != null;
    }

    public List<PhoneVersion> getAllPhoneVersion() {
        return dao.getAllPhoneVersion();
    }

    public boolean createPhoneVersion(PhoneVersion ent) {
        PhoneVersion phoneVersion = dao.getPhoneVersionBy(StringUtils.trim(ent.getVersion()), StringUtils.trim(ent.getChannel()));
        if (phoneVersion != null) {
           return false;
        } else {
            ent.setCts(new Date());
            ent.setUts(new Date());
            return dao.createPhoneVersion(ent) == 1;
        }
    }

    public boolean updatePhoneVersionById(PhoneVersion ent) {
        return dao.updatePhoneVersionById(ent) == 1;
    }

    public boolean updatePhoneVersionByIdAndForceupdate(int id, int forceUpdate) {
        return dao.updatePhoneVersionByIdAndForceUpdate(id, forceUpdate) == 1;
    }

    public boolean deletePhoneVersionById(long id) {
        return dao.deletePhoneVersionById(id) == 1;
    }

    public List<PhoneVersion> getPhoneVersionByPage(int startIndex, int pageSize) {
        return dao.getPhoneVersionByPage(startIndex, pageSize);
    }

    public int getPhoneVersionCount() {
        return dao.getPhoneVersionCount();
    }
}
