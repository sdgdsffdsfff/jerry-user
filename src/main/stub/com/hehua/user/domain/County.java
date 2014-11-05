/*
 * 由系统于2014-08-14 15:35:11生成。
 */

package com.hehua.user.domain;

import java.util.List;

import com.google.common.base.Function;

public class County extends CountyI {

    public static final Function<County, Integer> idExtractor = new Function<County, Integer>() {

        @Override
        public Integer apply(County input) {
            return input.getID();
        }

    };

    public static final Function<County, Integer> cityIDExtractor = new Function<County, Integer>() {

        @Override
        public Integer apply(County input) {
            return input.getCityID();
        }

    };

    private List<Town> towns;

    public List<Town> getTowns() {
        return towns;
    }

    public void setTowns(List<Town> towns) {
        this.towns = towns;
    }

}
