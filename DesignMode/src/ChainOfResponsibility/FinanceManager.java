package ChainOfResponsibility;

public class FinanceManager extends Reimbursement {

    public FinanceManager(String name) {
        super(name);
    }

    @Override
    public void requestForReimbursement(Proposer request) {
        if (request.getAmount() < 10000) {
            System.out.println(("报销金额为：" + request.getAmount() + ",被【" + name + "】报销了"));
        } else {
            if (nextHandler != null) {
                nextHandler.requestForReimbursement(request);
            }
        }
    }
}
