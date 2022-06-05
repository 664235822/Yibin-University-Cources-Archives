package account.controller;

import account.service.AccountService;
import account.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    public AccountController(){
        System.out.println("accountController 实例化");
    }

    public void save(Account account){
        accountService.save(account);
        System.out.println("accountController save");
    }
}
