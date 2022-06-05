package account.service;

import account.dao.AccountDao;
import account.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDao accountDao;

    public AccountServiceImpl(){
        System.out.println("accountService 实例化");
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
        System.out.println("accountService save");
    }
}
