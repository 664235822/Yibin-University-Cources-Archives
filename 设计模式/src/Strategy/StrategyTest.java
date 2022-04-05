package Strategy;

public class StrategyTest {

    public static void main(String[] args) {
        // write your code here
        CashContext cashContext = new CashContext(TYPE.CASH_DISCOUNT);
        System.out.println(cashContext.getResult(1000));

        cashContext = new CashContext(TYPE.CASH_RETURN);
        System.out.println(cashContext.getResult(1000));
    }
}