package zyd.myBatis.service.impl;

import org.springframework.transaction.annotation.Transactional;
import zyd.myBatis.mapper.CustomerMapper;
import zyd.myBatis.po.Customer;
import zyd.myBatis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	//注解注入CustomerMapper
	@Autowired
	private CustomerMapper customerMapper;
	//添加客户
	public void addCustomer(Customer customer) {
		this.customerMapper.addCustomer(customer);
//		int i=1/0; //模拟添加操作后系统突然出现的异常问题
	}

	@Override
	public Customer findCustomerById(Integer id) {
		return this.customerMapper.findCustomerById(id);
	}

	@Override
	public List<Customer> findAllCustomer() {
		return this.customerMapper.findAllCustomer();
	}

	@Override
	public void updatePhoneById(Customer customer) {
		this.customerMapper.updatePhoneById(customer);
	}


}
