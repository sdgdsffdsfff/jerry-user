package user.service;

import com.hehua.user.service.RegisterService;
import com.hehua.user.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    ConfigurableApplicationContext context;
    UserService userService;

    RegisterService registerService;

    @Before
    public void befor() {
        context = new ClassPathXmlApplicationContext("classpath*:/spring/applicationContext-*.xml");
        userService = (UserService) context.getBean("userService");
        registerService = context.getBean(RegisterService.class);
    }

    @Test
    public void testGetUserListByIds() throws Exception {
        List<Long> ids = new ArrayList<>();
        ids.add(Long.valueOf(100000));
        System.out.print(userService.getUserListByIds(ids).size());

    }

    @Test
    public void testRegisterUser() {
        System.out.println(registerService.registerUser("hellahdifh", "hello world", "qweasdrd"));
    }
}