package com.hehua.user.localcache;

import com.google.common.base.Function;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.hehua.commons.Transformers;
import com.hehua.user.domain.PhoneVersion;
import com.hehua.user.model.AppVer;
import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by hesheng on 14-9-28.
 */
public class PhoneVersionList {

    private static final Logger log = Logger.getLogger(PhoneVersionList.class);

    private final List<PhoneVersion> phoneVersionList;

    private final Map<Long, PhoneVersion> idMapPhoneVersion;

    private final Map<String, Channels> channelsMap;

    private final ListMultimap<String, PhoneVersion> channelMapPhoneVerList;

    public  Map<String, Channels> getChannelsMap() {
        return this.channelsMap;
    }

    public class Channels {
        private List<PhoneVersion> phoneVersionList;

        private Map<String, PhoneVersion> versionMapPhone;

        private Map<String, PhoneVersion> upgradeVersionMap;

        public PhoneVersion getUpdateInfo(SortedMap<String, PhoneVersion> versionMapPV, String version) {
            if (MapUtils.isEmpty(versionMapPV)) {
                return getLastPhoneVersion();
            }
            SortedMap<String, PhoneVersion> nextMaps = versionMapPV.tailMap(version);
            if (MapUtils.isEmpty(nextMaps)) {
                return getLastPhoneVersion();
            }

            PhoneVersion retVersion = null;
            List<PhoneVersion> subPhoneList = new ArrayList<>(nextMaps.values());
            for (PhoneVersion phoneVersion : subPhoneList) {
                if (phoneVersion.getForceupdate() == 1) {
                    retVersion = phoneVersion;
                }
            }

            if (retVersion == null) {
                retVersion = subPhoneList.get(subPhoneList.size() - 1);
            }

            PhoneVersion currentPhoneVersion = versionMapPV.get(version);
            if (currentPhoneVersion.getForceupdate() == 1) {
                retVersion.setForceupdate(1);
            } else {
                retVersion.setForceupdate(0);
            }

            return retVersion;
        }

        public PhoneVersion getLastPhoneVersion() {
            return this.phoneVersionList.get(phoneVersionList.size() - 1);
        }

    }

    public PhoneVersionList(List<PhoneVersion> phoneVersionList) {
        this.phoneVersionList = Collections.unmodifiableList(phoneVersionList);
        this.idMapPhoneVersion = Transformers.transformAsOneToOneMap(phoneVersionList, PhoneVersion.EXE_IDX);
        this.channelMapPhoneVerList = Transformers.transformAsListMultimap(phoneVersionList,
                new Function<PhoneVersion, String>() {
                    @Override
                    public String apply(PhoneVersion phoneVersion) {
                        return phoneVersion.getChannel();
                    }
        });

        channelsMap = new HashMap<>();
        Channels channels = null;
        for (String channel : channelMapPhoneVerList.keySet()) {
            channels = new Channels();
            channels.phoneVersionList = channelMapPhoneVerList.get(channel);
            Collections.sort(channels.phoneVersionList, new Comparator<PhoneVersion>() {
                @Override
                public int compare(PhoneVersion o1, PhoneVersion o2) {
                    return AppVer.of(o1.getVersion()).compareTo(AppVer.of(o2.getVersion()));
                }
            });

            channels.versionMapPhone = Transformers.transformAsOneToOneMap(channels.phoneVersionList, PhoneVersion.EXEACT_VERSION);

            SortedMap<String, PhoneVersion> versionMapPV = Maps.newTreeMap(new Comparator<String>() {
                @Override
                public int compare(String str1, String str2) {
                    return AppVer.of(str1).compareTo(AppVer.of(str2));
                }
            });
            for (PhoneVersion phoneVersion : channels.phoneVersionList) {
                try {
                    versionMapPV.put(phoneVersion.getVersion(), phoneVersion);
                } catch (Exception e) {
                    log.error("phoneVersion is illeage by version=" + phoneVersion.getVersion());
                }
            }

            channels.upgradeVersionMap = new HashMap<>();
            for (Map.Entry<String, PhoneVersion> entry : versionMapPV.entrySet()) {
                channels.upgradeVersionMap.put(entry.getKey(), channels.getUpdateInfo(versionMapPV, entry.getKey()));
            }
            channelsMap.put(channel, channels);
        }
    }

    public PhoneVersion getPhoneVersionById(long id) {
        return idMapPhoneVersion.get(id);
    }

    public List<PhoneVersion> getPhoneVersionAll() {
        return phoneVersionList;
    }

        public List<PhoneVersion> getPhoneVersionBy(String channel) {
        return channelMapPhoneVerList.get(channel);
    }

    public PhoneVersion getCurrentPhoneVersionBy(String channel, String version) {
        Channels channels = channelsMap.get(channel);
        if (channels == null) {
            return null;
        }
        return channels.versionMapPhone.get(version);
    }

    public PhoneVersion getUpgradePhoneVersionBy(String channel, String version) {
        Channels channels = channelsMap.get(channel);
        if (channels == null) {
            return null;
        }
        return channels.upgradeVersionMap.get(version);
    }
}
