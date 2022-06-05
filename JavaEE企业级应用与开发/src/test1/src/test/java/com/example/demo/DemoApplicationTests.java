package com.example.demo;

import com.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");

        UserService userService=(UserService) applicationContext.getBean("UserService");
        userService.sayHello();
    }

}
