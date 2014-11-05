package com.hehua.user.localcache;

import com.hehua.framework.localcache.AbstractLocalCache;
import com.hehua.user.dao.PhoneVersionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by hesheng on 14-9-28.
 */
@Component
public class PhoneVersionListLocalCache extends AbstractLocalCache<PhoneVersionList> {
    @Autowired
    private PhoneVersionDAO phoneVersionDAO;

    @Override
    public PhoneVersionList load() {
        return new PhoneVersionList(phoneVersionDAO.getAllPhoneVersion());
    }

    @Override
    public String key() {
        return "phoneVersion";
    }

    @Override
    public long getReloadPeriod() {
        return TimeUnit.DAYS.toMillis(1);
    }
}
