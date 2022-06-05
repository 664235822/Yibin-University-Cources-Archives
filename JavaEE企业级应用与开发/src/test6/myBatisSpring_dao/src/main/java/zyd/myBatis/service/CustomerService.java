package zyd.myBatis.service;
import zyd.myBatis.po.Customer;

public interface CustomerService {
    public boolean findCustomerById(Integer id);

    public boolean addCustomer(Customer customer);

    public boolean updateJobs(Customer customer);
}
