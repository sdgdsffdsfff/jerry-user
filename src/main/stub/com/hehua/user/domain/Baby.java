/*
 * 由系统于2014-08-07 15:49:14生成。
 */

package com.hehua.user.domain;

import java.text.ParseException;
import java.util.Date;

import com.hehua.commons.time.DateUtils;
import com.hehua.user.model.BabyStatus;
import com.hehua.user.model.BabyView;

public class Baby extends BabyI {

    public static final Baby DEFAULT = new Baby();

    public Baby() {
        setStatus(BabyStatus.Preparing.getCode());
    }

    public Baby(long uid) {
        setUid(uid);
        setStatus(BabyStatus.Preparing.getCode());
    }

    public Baby(BabyView babyParams) {

        setStatus(babyParams.getStatus());

        switch (babyParams.getStatus()) {
            case 1:
                setEdc(babyParams.getEdc());
                break;
            case 2:
                setGender(babyParams.getGender());
                setBirthday(babyParams.getBirthday());
                break;
            case 0:
                setStatus(0);
                break;
            case -1:
                setStatus(-1);
                break;
            default:
                setStatus(0);
                break;
        }

        if (!babyParams.isIsset()) {
            setStatus(-1);
        }
    }

    public Baby(int status, Date edc, int gender, Date birthday) {
        super();
        this.status = status;
        this.edc = edc;
        this.gender = gender;
        this.birthday = birthday;
    }

    public static Baby createNewBaby(boolean isset, int babyStatus, String edc, int gender,
            String birthDay) throws ParseException {

        if (!isset) {
            return new Baby(-1, null, 0, null);
        }

        switch (babyStatus) {
            case 1:
                return new Baby(babyStatus, DateUtils.parseDate(edc, "yyyy-MM-dd"), 0, null);
            case 2:
                return new Baby(babyStatus, null, gender, DateUtils.parseDate(birthDay,
                        "yyyy-MM-dd"));
            case 0:
            case -1:
            default:
                return new Baby(babyStatus, null, 0, null);
        }
    }

}
