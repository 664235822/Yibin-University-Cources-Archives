package account.dao;

import account.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

    public AccountDaoImpl(){
        System.out.println("accountDao 实例化");
    }

    @Override
    public void save(Account account) {
        System.out.println(account.toString());
        System.out.println("accountDao Save");
    }
}
