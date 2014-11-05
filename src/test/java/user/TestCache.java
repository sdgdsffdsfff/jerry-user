package user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hehua.user.domain.PhoneVersion;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hewenjerry on 14-9-18.
 */
public class TestCache extends TestCase {
    public String encode(PhoneVersion object) {
        return JSON.toJSONString(object);
    }

    public PhoneVersion decode(String text) {
        return JSON.parseObject(text, PhoneVersion.class);
    }

    public String encode(List<PhoneVersion> phoneVersionList) {
        JSONArray jsonArray = new JSONArray(phoneVersionList.size());
        for (PhoneVersion phoneVersion : phoneVersionList) {
            jsonArray.add(encode(phoneVersion));
        }
        return jsonArray.toJSONString();

    }

    public List<PhoneVersion> decodeList(String text) {
        List<PhoneVersion> phoneVersions = new ArrayList<>();
        JSONArray jsonArray = JSON.parseArray(text);
        for (int i = 0; i < jsonArray.size(); i++) {
            phoneVersions.add(decode(jsonArray.get(i).toString()));
        }
        return phoneVersions;
    }
    public void testString() {
        PhoneVersion phoneVersion = new PhoneVersion();
        phoneVersion.setUts(new Date());
        phoneVersion.setCts(new Date());
        phoneVersion.setForceupdate(1);
        phoneVersion.setChannel("ios");
        phoneVersion.setDownloadurl("http://ios.com");
        phoneVersion.setReleasenote("hell world");
        phoneVersion.setVersion("1.0");

        PhoneVersion phoneVersion1 = new PhoneVersion();
        phoneVersion1.setUts(new Date());
        phoneVersion1.setCts(new Date());
        phoneVersion1.setForceupdate(1);
        phoneVersion1.setChannel("android");
        phoneVersion1.setDownloadurl("http://android.com");
        phoneVersion1.setReleasenote("hell world1111");
        phoneVersion1.setVersion("1.0");

        List<PhoneVersion> list = new ArrayList<>(2);
        list.add(phoneVersion);
        list.add(phoneVersion1);

        String ss = encode(list);

        List<PhoneVersion> ret = decodeList(ss);
        for (PhoneVersion p : ret) {
            System.out.println(p.getChannel());
            System.out.println(p.getForceupdate());
            System.out.println(p.getVersion());
            System.out.println(p.getReleasenote());
            System.out.println(p.getDownloadurl());


        }

    }
}
