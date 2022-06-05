package zyd.myBatis.dao.impl;

import org.apache.ibatis.session.SqlSession;
import zyd.myBatis.dao.CustomerDao;
import zyd.myBatis.po.Customer;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/*
 * SqlSessionDaoSupport：是一个抽象支持类，它继承了DaoSupport类，
 * 主要是作为DAO的基类来使用。
 * 可以通过SqlSessionDaoSupport类的getSqlSession()方法来获取所需的SqlSession。
 * */
public class CustomerDaoImpl
        extends SqlSessionDaoSupport implements CustomerDao {
    // 通过id查询客户
    public Customer findCustomerById(Integer id) {
        return this.getSqlSession().selectOne("zyd.myBatis.CustomerMapperDao.findCustomerById", id);
    }

    @Override
    public void addCustomer(Customer customer) {
        this.getSqlSession().insert("zyd.myBatis.CustomerMapperDao.addCustomer", customer);
    }

    @Override
    public void updateJobs(Customer customer) {
        this.getSqlSession().update("zyd.myBatis.CustomerMapperDao.updateJobs", customer);
    }
}
