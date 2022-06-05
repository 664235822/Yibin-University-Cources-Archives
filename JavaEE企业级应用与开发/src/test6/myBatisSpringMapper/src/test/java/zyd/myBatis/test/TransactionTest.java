package zyd.myBatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import zyd.myBatis.mapper.CustomerMapper;
import zyd.myBatis.po.Customer;
import zyd.myBatis.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;

/**
 * 测试事务
 */
public class TransactionTest {

	private CustomerService customerService;

	@Before//在所有测试方法执行前执行该注解下的方法，用于资源打开
	public void getSession() throws IOException {//独立一个方法去获取SqlSession
		ApplicationContext act =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		customerService =
				act.getBean(CustomerService.class);
//        customerService=null;
		assertNotNull(customerService);
		System.out.println("customerService获取成功");
	}
	@Test
	public  void addCustomerTest() {

		Customer customer = new Customer();
		customer.setUsername("zhangsan");
		customer.setJobs("manager");
		customer.setPhone("13233334444");
		customerService.addCustomer(customer);
	}
	@Test
	public void findCustomerByIdTest(){
		Customer customer = customerService.findCustomerById(1);
		System.out.println("查询成功："+customer);
	}
}
