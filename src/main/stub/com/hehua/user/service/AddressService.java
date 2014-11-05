/*
 * 由系统于2014-08-01 17:35:56生成。
 */

package com.hehua.user.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.hehua.commons.ValidationUtils;
import com.hehua.commons.exception.BusinessException;
import com.hehua.commons.model.CommonMetaCode;
import com.hehua.commons.model.ResultView;
import com.hehua.user.domain.Address;
import com.hehua.user.domain.City;
import com.hehua.user.domain.County;
import com.hehua.user.domain.Province;
import com.hehua.user.exeception.InvalidMobileException;

@javax.inject.Named
public class AddressService extends AddressServiceI {

    private static final Logger log = Logger.getLogger(AddressService.class);

    @Autowired
    private LocationManager locationManager;

    public static final int MAX_SIZE = 20;

    public List<Address> getAddressListByUid(long uid) {
        return dao.getAddressListByUid(uid);
    }

    public Address getDefaultAddress(long uid) {
        return dao.getDefaultAddressByUid(uid);
    }

    public Address getRecentAddress(long uid) {
        return dao.getRecentAddressByUid(uid);
    }

    private boolean isValidReceiver(String name) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(name)) {
            return false;
        }

        int length = com.hehua.commons.lang.StringUtils.getChineseLength(name);
        if (length > 25) {
            return false;
        }
        return true;
    }

    private boolean isValidDetail(String detail) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(detail)) {
            return false;
        }

        int length = com.hehua.commons.lang.StringUtils.getChineseLength(detail);
        if (length < 5) {
            return false;
        }

        if (length > 120) {
            return false;
        }
        return true;
    }

    public ResultView<Address> addAddress(long uid, Address address) throws BusinessException {

        if (!isValidReceiver(address.getReceiver())) {
            throw new BusinessException(AddressResultCode.INVALID_RECEIVER);
        }

        if (!ValidationUtils.isValidMobile(address.getMobile())) {
            throw new InvalidMobileException();
        }

        Province province = locationManager.getProvince(address.getProvince());
        if (province == null) {
            throw new BusinessException(AddressResultCode.INVALID_PROVINCE);
        }

        City city = locationManager.getCity(address.getCity());
        if (city == null) {
            throw new BusinessException(AddressResultCode.INVALID_CITY);
        }

        County county = locationManager.getCounty(address.getCounty());
        if (county == null) {
            throw new BusinessException(AddressResultCode.INVALID_COUNTY);
        }

        if (!isValidDetail(address.getDetail())) {
            throw new BusinessException(AddressResultCode.INVALID_DETAIL);
        }

        if (!ValidationUtils.isValidPostCode(address.getPostcode())) {
            throw new BusinessException(AddressResultCode.INVALID_POSTCODE);
        }

        int addressesCount = this.dao.countAddresses(uid);
        if (addressesCount >= MAX_SIZE) {
            throw new BusinessException(AddressResultCode.TOO_MANY_ADDRESSES);
        }

        address.setUid(uid);
        address.setCts(new Date());
        address.setUts(new Date());
        // unset default
        if (address.getIsdefault()) {
            this.dao.removeDefault(uid);
        }
        this.dao.createAddress(address);
        return new ResultView<Address>(CommonMetaCode.Success, address);
    }

    public ResultView<Address> deleteAddress(long uid, int id) {

        Address address = this.dao.getAddressById(id);

        if (address.getUid() != uid) {
            throw new RuntimeException("");
        }

        this.dao.deleteAddressById(id);

        return new ResultView<Address>(CommonMetaCode.Success, address);
    }

    public ResultView<Address> modifyAddress(long uid, Address address) throws BusinessException {
        if (!isValidReceiver(address.getReceiver())) {
            throw new BusinessException(AddressResultCode.INVALID_RECEIVER);
        }

        if (!ValidationUtils.isValidMobile(address.getMobile())) {
            throw new InvalidMobileException();
        }

        Province province = locationManager.getProvince(address.getProvince());
        if (province == null) {
            throw new BusinessException(AddressResultCode.INVALID_PROVINCE);
        }

        City city = locationManager.getCity(address.getCity());
        if (city == null) {
            throw new BusinessException(AddressResultCode.INVALID_CITY);
        }

        County county = locationManager.getCounty(address.getCounty());
        if (county == null) {
            throw new BusinessException(AddressResultCode.INVALID_COUNTY);
        }

        if (!isValidDetail(address.getDetail())) {
            throw new BusinessException(AddressResultCode.INVALID_DETAIL);
        }

        address.setPostcode(address.getPostcode().trim());
        if (!ValidationUtils.isValidPostCode(address.getPostcode())) {
            throw new BusinessException(AddressResultCode.INVALID_POSTCODE);
        }

        Address oldAddress = dao.getAddressById(address.getId());
        if (oldAddress == null) {
            throw new BusinessException(AddressResultCode.ADDRESS_NOT_FOUND);
        }

        address.setUid(uid);
        address.setCts(oldAddress.getCts());
        address.setUts(new Date());
        // unset default
        if (address.getIsdefault()) {
            this.dao.removeDefault(uid);
        }
        this.dao.updateAddressById(address);
        return new ResultView<Address>(CommonMetaCode.Success, address);
    }

    public ResultView<Address> setDefaultAddress(long uid, int addressId) throws BusinessException {
        Address oldAddress = dao.getAddressById(addressId);
        if (oldAddress == null) {
            throw new BusinessException(AddressResultCode.ADDRESS_NOT_FOUND);
        }

        if (oldAddress.getIsdefault()) {
            return new ResultView<Address>(CommonMetaCode.Success, oldAddress);
        }

        this.dao.removeDefault(uid);

        oldAddress.setIsdefault(true);
        this.dao.updateDefault(addressId, true);

        return new ResultView<Address>(CommonMetaCode.Success, oldAddress);
    }
}
