package zyd.myBatis.dao;
import zyd.myBatis.po.Customer;

public interface CustomerDao {
	// 通过id查询客户
	public Customer findCustomerById(Integer id);

	public void addCustomer(Customer customer);

	public void updateJobs(Customer customer);
}
