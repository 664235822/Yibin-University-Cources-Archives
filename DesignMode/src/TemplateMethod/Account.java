package TemplateMethod;

public abstract class Account {

    public abstract String getAccountTyoe();

    public abstract double getInterestRate();

    public double depositAmount(String accountType){
        return 10000;
    }

    public final double calculateInterest(){
        double dbRate=getInterestRate();
        String accountType=getAccountTyoe();
        double dbAmount=depositAmount(accountType);

        return (dbAmount*dbRate);
    }
}
