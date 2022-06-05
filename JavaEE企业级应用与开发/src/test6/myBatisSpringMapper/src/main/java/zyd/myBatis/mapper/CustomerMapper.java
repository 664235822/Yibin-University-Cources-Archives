package zyd.myBatis.mapper;
import zyd.myBatis.po.Customer;

import java.util.List;

public interface CustomerMapper {
	// 通过id查询客户
	public Customer findCustomerById(Integer id);
	
	// 添加客户
	public void addCustomer(Customer customer);

	public List<Customer> findAllCustomer();

	public void updatePhoneById(Customer customer);
}
