package TemplateMethod;

public class TimeAccount extends Account {

    private String accountType="李四的活期账户";
    private double rate=0.00325;

    @Override
    public String getAccountTyoe(){
        return accountType;
    }

    @Override
    public double getInterestRate(){
        return rate;
    }
}
