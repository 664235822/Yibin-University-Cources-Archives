package Strategy;

public class CashDiscount implements CashSuper {

    private double moneyDiscount;

    public CashDiscount(double moneyDiscount){
        this.moneyDiscount=moneyDiscount;
    }

    @Override
    public double acceptCash(double money){
        return money*moneyDiscount;
    }
}
