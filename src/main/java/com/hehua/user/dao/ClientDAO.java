/**
 * 
 */
package com.hehua.user.dao;

import javax.inject.Named;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.hehua.user.model.Client;

/**
 * @author zhihua
 *
 */
@Named
public interface ClientDAO {

    @Insert("insert into `client` (`clientid`, `deviceid`, `os`, `appversion`, `channel`, `dm`, `cts`)"
            + " values (#{clientid}, #{deviceid}, #{os}, #{appversion}, #{channel}, #{dm}, #{cts})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int create(Client client);
}
