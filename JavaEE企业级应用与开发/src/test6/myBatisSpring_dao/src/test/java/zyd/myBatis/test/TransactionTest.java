package zyd.myBatis.test;

import org.junit.Test;
import zyd.myBatis.po.Customer;
import zyd.myBatis.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试事务
 */
public class TransactionTest {
	@Test
	public  void transactionTest() {
		ApplicationContext act =
             new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService =
                                            act.getBean(CustomerService.class);
		customerService.findCustomerById(1);
	}
}
