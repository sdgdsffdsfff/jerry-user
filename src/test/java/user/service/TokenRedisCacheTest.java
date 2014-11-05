package user.service;

import com.hehua.user.domain.Token;
import com.hehua.user.service.TokenRedisCache;
import com.hehua.user.service.UserService;
import com.peaceful.util.Util;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TokenRedisCacheTest {

    ConfigurableApplicationContext context;
    TokenRedisCache tokenRedisCache = null;
    Date date = new Date();

    @Before
    public void befor() {
        context = new ClassPathXmlApplicationContext("classpath*:/spring/applicationContext-*.xml");
        tokenRedisCache = (TokenRedisCache) context.getBean("tokenRedisCache");
    }


    @Test
    public void testEncode() throws Exception {

    }

    @Test
    public void testDecode() throws Exception {

    }

    @Test
    public void testBuildKey() throws Exception {

    }

    @Test
    public void put() {
        Token token = new Token();
        token.setLastlogin(date);
        token.setCts(date);
        token.setUts(date);
        token.setToken("123");
        tokenRedisCache.set("123",token);
    }

    @Test
    public void get() {
        Util.report(tokenRedisCache.get("123").getLastlogin());
    }


}