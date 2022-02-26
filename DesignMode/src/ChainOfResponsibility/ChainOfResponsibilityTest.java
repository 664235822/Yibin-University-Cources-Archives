package ChainOfResponsibility;

public class ChainOfResponsibilityTest {

    public static void main(String[] args) {
        // write your code here

        Cashier cashier = new Cashier("林出纳");
        FinanceManager financeManager = new FinanceManager("李经理");
        CFO cfo = new CFO("王总监");

        cashier.setNextHandler(financeManager);
        financeManager.setNextHandler(cfo);

        Proposer proposer = new Proposer();
        proposer.setAmount(50);

        cashier.requestForReimbursement(proposer);
    }
}