package user;

import com.hehua.user.domain.PhoneVersion;
import com.hehua.user.localcache.PhoneVersionList;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hesheng on 14-9-28.
 */
public class TestPhoneVersion extends TestCase {
    public void testLocalCache() {
        List<PhoneVersion> phoneList = new ArrayList<>();
        PhoneVersion phoneVersion1 = new PhoneVersion();
        phoneVersion1.setChannel("android");
        phoneVersion1.setVersion("1.0.1");
        phoneVersion1.setForceupdate(1);
        phoneList.add(phoneVersion1);
        PhoneVersion phoneVersion2 = new PhoneVersion();
        phoneVersion2.setChannel("android");
        phoneVersion2.setVersion("2.1.2");
        phoneVersion2.setForceupdate(1);
        phoneList.add(phoneVersion2);
        PhoneVersion phoneVersion3 = new PhoneVersion();
        phoneVersion3.setChannel("android");
        phoneVersion3.setVersion("3.0.3");
        phoneVersion3.setForceupdate(0);
        phoneList.add(phoneVersion3);
        PhoneVersion phoneVersion4 = new PhoneVersion();
        phoneVersion4.setChannel("android");
        phoneVersion4.setVersion("2.0.4");
        phoneVersion4.setForceupdate(1);
        phoneList.add(phoneVersion4);
        PhoneVersionList phoneVersionList = new PhoneVersionList(phoneList);
        System.out.println(phoneVersionList.getChannelsMap().get("android").getLastPhoneVersion());

        System.out.println(phoneVersionList.getChannelsMap().get("android"));


    }
}
