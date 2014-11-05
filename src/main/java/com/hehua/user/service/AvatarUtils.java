/**
 * 
 */
package com.hehua.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hehua.framework.image.ImageService;
import com.hehua.framework.image.domain.Image;

/**
 * @author zhihua
 *
 */
@Component
public class AvatarUtils {

    @Autowired
    private ImageService imageService;

    public String getAvatarUrl(long avatarId) {
        if (avatarId > 0) {
            return "http://img.hehuababy.com/head_new.jpg";
        }

        Image image = imageService.getImageById(avatarId);
        if (image != null) {
            return image.getUrl();
        }
        return "http://img.hehuababy.com/head_new.jpg";
    }
}
