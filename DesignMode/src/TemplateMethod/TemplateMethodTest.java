package TemplateMethod;

public class TemplateMethodTest {

    public static void main(String[] args) {
        // write your code here

        Account account =new CurrentAccount();
        System.out.println(account.calculateInterest());

        account=new TimeAccount();
        System.out.println(account.calculateInterest());
    }
}
