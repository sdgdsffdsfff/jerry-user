/**
 * 
 */
package com.hehua.user.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @author zhihua
 *
 */
@Component
public class NameService {

    public String generateRandomName() {
        return RandomStringUtils.randomAlphabetic(3).toLowerCase()
                + RandomStringUtils.randomNumeric(9);
    }

}
