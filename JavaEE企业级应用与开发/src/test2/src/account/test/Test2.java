package account.test;

import account.config.AccountConfig;
import account.controller.AccountController;
import account.entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountConfig.class);

        Account account = applicationContext.getBean(Account.class);
        AccountController accountController = applicationContext.getBean(AccountController.class);

        accountController.save(account);

        Account account2 = applicationContext.getBean(Account.class);
        account2.setId(2);
        account2.setName("Mike");
        account2.setMoney(2000);
        AccountController accountController2 = applicationContext.getBean(AccountController.class);

        accountController2.save(account2);
    }
}
