package Strategy;

public class CashContext {

    private CashSuper cashSuper;

    public CashContext(TYPE type){
        switch(type){
            case NORMAL:
                cashSuper=new CashNormal();
                break;
            case CASH_DISCOUNT:
                cashSuper=new CashDiscount(0.8);
                break;
            case CASH_RETURN:
                cashSuper=new CashReturn(300,100);
                break;
        }
    }

    public double getResult(double money){
        return cashSuper.acceptCash(money);
    }
}
