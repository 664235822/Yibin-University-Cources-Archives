package zyd.myBatis.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zyd.myBatis.po.Customer;
import zyd.myBatis.service.CustomerService;

import java.util.List;

public class DemoTest {

    private CustomerService customerService;

    @Test
    public void findAllCustomer(){
        ApplicationContext act =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        customerService =
                act.getBean(CustomerService.class);

        List<Customer> list=customerService.findAllCustomer();
        for (Customer customer: list) {
            System.out.println(customer);
        }
    }

    @Test
    public void updatePhoneById(){
        ApplicationContext act =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        customerService =
                act.getBean(CustomerService.class);

        Customer customer=new Customer();
        customer.setId(2);
        customer.setPhone("13982749396");
        customerService.updatePhoneById(customer);
    }
}
