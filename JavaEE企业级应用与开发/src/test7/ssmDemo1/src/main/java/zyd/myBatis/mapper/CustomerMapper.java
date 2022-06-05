package zyd.myBatis.mapper;

import zyd.myBatis.po.Customer;

import java.util.List;

public interface CustomerMapper {
	// 通过id查询客户
	public Customer findCustomerById(String username);

	// 添加客户
	public void addCustomer(Customer customer);

	public List<Customer> listCustomers();

	public void updateCustomer(Customer customer);

	public void deleteCustomerById(String username);
}
