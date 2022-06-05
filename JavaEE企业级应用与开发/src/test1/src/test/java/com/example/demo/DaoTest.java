package com.example.demo;

import com.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
public class DaoTest {
        @Test
        void contextLoads() {
            ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");

            UserDao userDao=(UserDao) applicationContext.getBean("UserDao");
            userDao.say();
        }



}
