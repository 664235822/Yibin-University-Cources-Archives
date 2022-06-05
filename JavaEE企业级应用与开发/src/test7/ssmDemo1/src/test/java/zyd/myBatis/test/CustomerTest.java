package zyd.myBatis.test;
import org.junit.Before;
import org.junit.Test;
import zyd.myBatis.po.Customer;
import zyd.myBatis.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

/**
 * 测试事务
 */
public class CustomerTest {

	private CustomerService customerService;

	@Before//在所有测试方法执行前执行该注解下的方法，用于资源打开
	public void getService() throws IOException {//独立一个方法去获取SqlService
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
		Customer customer = customerService.findCustomerById("朱方灏钧");
		System.out.println("查询成功："+customer);
	}
	@Test
	public void listCustomers(){
		ArrayList<Customer> customers = customerService.getCustomers();
		System.out.println("查询所有成功：");
		for (Customer customer : customers) {//增强for循环打印查询结果
			System.out.println("customer:" + customer);
		}
	}
}
