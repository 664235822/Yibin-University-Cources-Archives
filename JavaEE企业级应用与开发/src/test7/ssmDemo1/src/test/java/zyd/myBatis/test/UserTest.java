package zyd.myBatis.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zyd.myBatis.po.User;
import zyd.myBatis.service.UserService;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * 测试事务
 */
public class UserTest {

	private UserService userService;

	@Before//在所有测试方法执行前执行该注解下的方法，用于资源打开
	public void getService() throws IOException {//独立一个方法去获取SqlService
		ApplicationContext act =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		userService =
				act.getBean(UserService.class);
//        userService=null;
		assertNotNull(userService);
		System.out.println("userService获取成功");
	}
	@Test
	public  void addUserTest() {
		User user = new User();
		user.setUsername("tom");
		user.setPassword("123");
		userService.register(user);
	}
	@Test
	public void findUserByUsernameTest(){
		User userForm=new User();
		userForm.setUsername("Lucy");
		userForm.setPassword("abc");
		User user = userService.login(userForm);
		if (user!=null){
			System.out.println("查询成功："+user);
		}
		else {
			System.out.println("查询失败："+user);
		}
	}
}
