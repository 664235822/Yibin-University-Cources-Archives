package TemplateMethod;

public class CurrentAccount extends Account{

    private String accountType="张三的活期账户";
    private double rate=0.00525;

    @Override
    public String getAccountTyoe(){
        return accountType;
    }

    @Override
    public double getInterestRate(){
        return rate;
    }
}
