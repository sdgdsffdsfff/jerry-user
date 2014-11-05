/*
 * 由系统于2014-08-29 13:39:17生成。
 */

package com.hehua.user.service;

import com.hehua.commons.collection.CollectionUtils;
import com.hehua.user.dao.PhoneVersionDAO;
import com.hehua.user.domain.PhoneVersion;
import com.hehua.user.localcache.PhoneVersionList;
import com.hehua.user.localcache.PhoneVersionListLocalCache;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class PhoneVersionService implements InitializingBean{

    private static final Logger log = Logger.getLogger(PhoneVersionService.class);

    @Autowired
    private PhoneVersionListLocalCache phoneVersionListLocalCache;

    @Autowired
    private PhoneVersionDAO phoneVersionDAO;

    public PhoneVersion getCurrentPhoneVersion(final String version, final String channel) {
       return phoneVersionListLocalCache.get().getCurrentPhoneVersionBy(channel, version);
    }

    public PhoneVersion getPhoneVersionBy(String version, String channel) {
        if (log.isInfoEnabled()) {
            log.info(String.format("version=%s, channel=%s", version, channel));
        }

        channel = StringUtils.trim(channel);
        version = StringUtils.trim(version);
        PhoneVersion upgrade = phoneVersionListLocalCache.get().getUpgradePhoneVersionBy(channel, version);
        if (upgrade == null) {
            log.info(String.format("version=%s, channel=%s is not exist upgrade", version, channel));
        } else {
            return upgrade;
        }

        PhoneVersion currentPhoneVersion = getCurrentPhoneVersion(version, channel);
        if (currentPhoneVersion == null) {
            log.info(String.format("current ,version=%s, channel=%s is not exist", version, channel));
            PhoneVersionList.Channels channels = phoneVersionListLocalCache.get().getChannelsMap().get(channel);
            if (channels != null) {
                return channels.getLastPhoneVersion();
            } else {
                log.info(String.format("all channel=%s is not exist upgrade", version, channel));
                return null;
            }
        } else {
            return currentPhoneVersion;
        }
    }

    /**
     * 获取某个渠道的最新版本
     * @param channel
     * @return
     */
    public PhoneVersion getlatestPhoneVersionOf(String channel) {
        if (StringUtils.isBlank(channel)) {
            return null;
        }
        Map<String, PhoneVersionList.Channels> channelsMap =  phoneVersionListLocalCache.get().getChannelsMap();
        if (!channelsMap.containsKey(channel)) {
            return null;
        }
        PhoneVersionList.Channels channels = channelsMap.get(channel);
        return channels.getLastPhoneVersion();
    }

    public PhoneVersion getPhoneVersionById(long id) {
        return phoneVersionListLocalCache.get().getPhoneVersionById(id);
    }

    public boolean hasPhoneVersionWithId(long id) {
       return phoneVersionListLocalCache.get().getPhoneVersionById(id) != null ? true : false;
    }

    public List<PhoneVersion> getAllPhoneVersion() {
        return phoneVersionListLocalCache.get().getPhoneVersionAll();
    }

    public boolean createPhoneVersion(PhoneVersion ent) {
        PhoneVersion phoneVersion = this.getCurrentPhoneVersion(StringUtils.trim(ent.getVersion()), StringUtils.trim(ent.getChannel()));
        if (phoneVersion != null) {
            phoneVersion.setDownloadurl(ent.getDownloadurl());
            phoneVersion.setForceupdate(ent.getForceupdate());
            phoneVersion.setReleasenote(ent.getReleasenote());
            phoneVersion.setVersion(ent.getVersion());
            phoneVersion.setChannel(ent.getChannel());
            phoneVersion.setUts(new Date());
            if (phoneVersionDAO.updatePhoneVersionById(ent) == 1) {
                phoneVersionListLocalCache.postReloadMessage();
                return true;
            } else {
                return false;
            }
        } else {
            ent.setCts(new Date());
            ent.setUts(new Date());
            if (phoneVersionDAO.createPhoneVersion(ent) == 1) {
                phoneVersionListLocalCache.postReloadMessage();
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean updatePhoneVersionById(PhoneVersion ent) {
        if (phoneVersionDAO.updatePhoneVersionById(ent) == 1) {
            phoneVersionListLocalCache.postReloadMessage();
            return true;
        }
        return false;
    }

    public boolean updatePhoneVersionByIdAndForceupdate(int id, int forceUpdate) {
        if (phoneVersionDAO.updatePhoneVersionByIdAndForceUpdate(id, forceUpdate) == 1) {
            phoneVersionListLocalCache.postReloadMessage();
            return true;
        }
        return false;
    }

    public boolean deletePhoneVersionById(long id) {
        if (phoneVersionDAO.deletePhoneVersionById(id) == 1) {
            phoneVersionListLocalCache.postReloadMessage();
            return true;
        }
        return false;
    }

    public List<PhoneVersion> getPhoneVersionByPage(int startIndex, int pageSize) {
        return CollectionUtils.subList(phoneVersionListLocalCache.get().getPhoneVersionAll(), startIndex, pageSize);
    }

    public int getPhoneVersionCount() {
        return phoneVersionListLocalCache.get().getPhoneVersionAll().size();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
