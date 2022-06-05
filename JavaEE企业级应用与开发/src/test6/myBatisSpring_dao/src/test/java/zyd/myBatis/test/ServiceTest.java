package zyd.myBatis.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zyd.myBatis.po.Customer;
import zyd.myBatis.service.CustomerService;

public class ServiceTest {

    @Test
    public void addCustomer() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService = (CustomerService) applicationContext.getBean(CustomerService.class);

        Customer customer = new Customer();
        customer.setId(2);
        customer.setUsername("朱方灏钧");
        customer.setPhone("13404098516");
        customer.setJobs("学生");

        System.out.println("添加角色" + (customerService.addCustomer(customer) ? "成功:" : "失败"));
    }

    @Test
    public void updateJobs(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService = (CustomerService) applicationContext.getBean(CustomerService.class);

        Customer customer = new Customer();
        customer.setId(2);
        customer.setJobs("游戏工程师");

        System.out.println("更新角色信息" + (customerService.updateJobs(customer) ? "成功:" : "失败"));
    }
}
