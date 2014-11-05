package com.hehua.user.service;

import com.hehua.user.domain.Token;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

public class TokenServiceTest {

    ConfigurableApplicationContext context;
    TokenService tokenService;

    Date date = new Date();


    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("classpath*:/spring/applicationContext-*.xml");
        tokenService = (TokenService) context.getBean("tokenService");

    }

    @Test
    public void testAfterPropertiesSet() throws Exception {

    }

    @Test
    public void testVerfiyToken() throws Exception {

    }

    @Test
    public void testCreateToken() throws Exception {
        Token token = new Token();
        token.setLastlogin(date);
        token.setCts(date);
        token.setUts(date);
        token.setToken("123");
        tokenService.createToken(token);
    }

    @Test
    public void testDeleteTokenByToken() throws Exception {

    }

    @Test
    public void testGetTokenByToken() throws Exception {

    }
}