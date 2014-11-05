/*
 * 由系统于2014-08-14 15:35:10生成。
 */

package com.hehua.user.domain;

import java.util.List;

import com.google.common.base.Function;

public class City extends CityI {

    public static final Function<City, Integer> idExtractor = new Function<City, Integer>() {

        @Override
        public Integer apply(City input) {
            return input.getID();
        }

    };

    public static final Function<City, Integer> provinceIDExtractor = new Function<City, Integer>() {

        @Override
        public Integer apply(City input) {
            return input.getProvinceID();
        }

    };

    private List<County> counties;

    public List<County> getCounties() {
        return counties;
    }

    public void setCounties(List<County> counties) {
        this.counties = counties;
    }

}
