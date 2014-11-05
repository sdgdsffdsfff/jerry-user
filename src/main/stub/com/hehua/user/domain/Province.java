/*
 * 由系统于2014-08-14 15:35:10生成。
 */

package com.hehua.user.domain;

import java.util.List;

import com.google.common.base.Function;

public class Province extends ProvinceI {

    public static final Function<Province, Integer> idExtractor = new Function<Province, Integer>() {

        @Override
        public Integer apply(Province input) {
            return input.getID();
        }

    };

    private List<City> cities;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

}
