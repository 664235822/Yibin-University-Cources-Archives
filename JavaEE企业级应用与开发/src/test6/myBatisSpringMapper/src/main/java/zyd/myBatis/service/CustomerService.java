package zyd.myBatis.service;
import zyd.myBatis.po.Customer;

import java.util.List;

public interface CustomerService {
    public void addCustomer(Customer customer);
    public Customer findCustomerById(Integer id);

    public List<Customer> findAllCustomer();

    public void updatePhoneById(Customer customer);
}
