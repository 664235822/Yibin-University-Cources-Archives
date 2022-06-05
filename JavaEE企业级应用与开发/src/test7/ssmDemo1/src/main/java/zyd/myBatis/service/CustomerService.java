package zyd.myBatis.service;

import zyd.myBatis.po.Customer;

import java.util.ArrayList;

public interface CustomerService {
    public boolean addCustomer(Customer customer);

    public Customer findCustomerById(String username);

    public ArrayList<Customer> getCustomers();

    public boolean updateCustomer(Customer customer);

    public boolean deleteCustomerById(String username);
}
