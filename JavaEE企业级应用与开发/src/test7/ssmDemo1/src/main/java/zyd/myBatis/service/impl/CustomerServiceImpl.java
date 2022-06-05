package zyd.myBatis.service.impl;

import org.springframework.transaction.annotation.Transactional;
import zyd.myBatis.mapper.CustomerMapper;
import zyd.myBatis.po.Customer;
import zyd.myBatis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	//注解注入CustomerMapper
	@Autowired
	private CustomerMapper customerMapper;

	//添加客户
	public boolean addCustomer(Customer customer) {
		this.customerMapper.addCustomer(customer);
//		int i=1/0; //模拟添加操作后系统突然出现的异常问题
		return true;
	}

	@Override
	public Customer findCustomerById(String username) {
		return this.customerMapper.findCustomerById(username);
	}

	@Override
	public ArrayList<Customer> getCustomers() {
		return (ArrayList<Customer>) this.customerMapper.listCustomers();
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		this.customerMapper.updateCustomer(customer);
		return true;
	}

	@Override
	public boolean deleteCustomerById(String username) {
		this.customerMapper.deleteCustomerById(username);
		return true;
	}
}
