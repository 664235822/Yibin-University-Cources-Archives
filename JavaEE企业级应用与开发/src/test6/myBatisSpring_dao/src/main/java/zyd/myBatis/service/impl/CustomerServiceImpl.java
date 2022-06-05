package zyd.myBatis.service.impl;

import org.springframework.transaction.annotation.Transactional;
import zyd.myBatis.dao.CustomerDao;
import zyd.myBatis.po.Customer;
import zyd.myBatis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    //注解注入CustomerMapper
    @Autowired
    private CustomerDao customerDao;

    //添加客户
    public boolean findCustomerById(Integer id) {
        if (this.customerDao.findCustomerById(id) != null) {
            return true;
        }
//		int i=1/0; //模拟添加操作后系统突然出现的异常问题
        return false;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        try {
            this.customerDao.addCustomer(customer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJobs(Customer customer) {
        try {
            this.customerDao.updateJobs(customer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
