package com.example.demo;

import com.entity.A;
import com.entity.C;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
public class EntityTest {

    @Test
    void contextLoads() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");

        A b=(A) applicationContext.getBean("B");
        b.run();

        A c=(A)applicationContext.getBean(C.class);
        c.run();
    }
}
