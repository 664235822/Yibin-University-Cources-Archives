package Strategy;

enum TYPE{
    NORMAL,
    CASH_DISCOUNT,
    CASH_RETURN
};

public interface CashSuper {

    public double acceptCash(double money);
}
