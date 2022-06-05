package zyd.myBatis.test;

import zyd.myBatis.dao.CustomerDao;
import zyd.myBatis.po.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DAO测试类
 */
public class DaoTest {
	@Test
	public void findCustomerByIdDaoTest(){
		ApplicationContext act = 
		    new ClassPathXmlApplicationContext("applicationContext.xml");
          // 根据容器中Bean的id来获取指定的Bean
	     CustomerDao customerDao = (CustomerDao) act.getBean("customerDao");
//	     CustomerDao customerDao = act.getBean(CustomerDao.class);
		 Customer customer = customerDao.findCustomerById(1);
		 System.out.println("查询后结果："+customer);
	}


}
