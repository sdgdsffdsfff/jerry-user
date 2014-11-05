/*
 * 由系统于2014-08-07 15:49:14生成。
 */

package com.hehua.user.service;

import org.apache.log4j.Logger;

import com.hehua.commons.model.CommonMetaCode;
import com.hehua.commons.model.ResultView;
import com.hehua.user.domain.Baby;
import com.hehua.user.model.BabyView;
import com.hehua.user.model.Gender;

@javax.inject.Named
public class BabyService extends BabyServiceI {

    private static final Logger log = Logger.getLogger(BabyService.class);

    public boolean validateBabyParams(BabyView babyParams) {

        switch (babyParams.getStatus()) {
            case 1:
                if (babyParams.getEdc() == null) {
                    return false;
                }
                return true;
            case 2:

                if (babyParams.getBirthday() == null) {
                    return false;
                }
                if (babyParams.getGender() < Gender.Unkown.getCode()
                        || babyParams.getGender() > Gender.Female.getCode()) {
                    return false;
                }
                return true;
            case 0:
                return true;
            case -1:
                return true;
            default:
                return false;

        }
    }

    public Baby getOrCreateBabyByUid(long uid) {
        Baby baby = dao.getBabyByUidxUid(uid);
        if (baby == null) {
            baby = new Baby(uid);
            int bid = dao.createBaby(baby);
            baby.setId(bid);
        }
        return baby;
    }

    public ResultView<BabyView> updateBaby(long uid, BabyView babyParams) {
        if (!validateBabyParams(babyParams)) {
            // TODO
            throw new RuntimeException("");
        }

        Baby baby = new Baby(babyParams);
        baby.setUid(uid);
        this.dao.updateBabyByUid(baby);

        return new ResultView<BabyView>(CommonMetaCode.Success, new BabyView(baby));
    }
}
