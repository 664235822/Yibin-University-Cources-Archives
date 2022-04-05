package Strategy;

public class CashNormal implements CashSuper {

    @Override
    public double acceptCash(double money){
        return money;
    }
}
