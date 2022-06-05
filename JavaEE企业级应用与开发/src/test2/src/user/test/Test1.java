package user.test;

import user.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");

        User user1=(User) applicationContext.getBean("user1");
        System.out.println(user1.toString());

        User user2=(User) applicationContext.getBean("user2");
        System.out.println(user2.toString());
    }
}
