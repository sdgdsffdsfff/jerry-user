/**
 * 
 */
package com.hehua.user.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.ListMultimap;
import com.hehua.commons.Transformers;
import com.hehua.user.dao.CityDAO;
import com.hehua.user.dao.CountyDAO;
import com.hehua.user.dao.ProvinceDAO;
import com.hehua.user.dao.TownDAO;
import com.hehua.user.domain.City;
import com.hehua.user.domain.County;
import com.hehua.user.domain.Province;
import com.hehua.user.domain.Town;

/**
 * 
 * TODO 暂时使用全静态数据，将改为统一的缓存框架
 * 
 * @author zhihua
 *
 */
@Component
public class LocationManager implements InitializingBean {

    @Autowired
    private ProvinceDAO provinceDAO;

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private CountyDAO countyDAO;

    @Autowired
    private TownDAO townDAO;

    private List<Province> provinceList = null;

    private Map<Integer, Province> provinceMapById = null;

    private Map<Integer, City> cityMapById = null;

    private Map<Integer, County> countyMapById = null;

    private Map<Integer, Town> townMapById = null;

    @Override
    public void afterPropertiesSet() throws Exception {

        List<Province> allProvince = provinceDAO.getAllProvince();

        List<City> allCities = cityDAO.getAllCity();

        List<County> allCounties = countyDAO.getAllCounty();

        List<Town> towns = new ArrayList<>();

        ListMultimap<Integer, City> citiesByProvince = Transformers.transformAsListMultimap(
                allCities, City.provinceIDExtractor);
        ListMultimap<Integer, County> countiesByCity = Transformers.transformAsListMultimap(
                allCounties, County.cityIDExtractor);

        for (Province province : allProvince) {
            province.setCities(Collections.unmodifiableList(citiesByProvince.get(province.getID())));
        }

        for (City city : allCities) {
            city.setCounties(Collections.unmodifiableList(countiesByCity.get(city.getID())));
        }

        this.provinceList = Collections.unmodifiableList(allProvince);
        this.provinceMapById = Collections.unmodifiableMap(Transformers.transformAsOneToOneMap(
                provinceList, Province.idExtractor));
        this.cityMapById = Collections.unmodifiableMap(Transformers.transformAsOneToOneMap(
                allCities, City.idExtractor));
        this.countyMapById = Collections.unmodifiableMap(Transformers.transformAsOneToOneMap(
                allCounties, County.idExtractor));
        this.townMapById = Collections.unmodifiableMap(new HashMap<Integer, Town>());

    }

    public List<Province> getAllProvince() {
        return provinceList;
    }

    public Province getProvince(int provinceId) {
        return provinceMapById.get(provinceId);
    }

    public City getCity(int cityId) {
        return cityMapById.get(cityId);
    }

    public County getCounty(int countyId) {
        return countyMapById.get(countyId);
    }

    public Town getTown(int townId) {
        return townMapById.get(townId);
    }

}
