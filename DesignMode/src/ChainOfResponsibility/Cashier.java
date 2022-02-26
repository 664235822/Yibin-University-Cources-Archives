package ChainOfResponsibility;

public class Cashier extends Reimbursement {

    public Cashier(String name) {
        super(name);
    }

    @Override
    public void requestForReimbursement(Proposer request) {
        if (request.getAmount() < 100) {
            System.out.println("报销金额低于100不予报销，被【" + name + "】拒绝了");
        } else {
            if (nextHandler != null) {
                nextHandler.requestForReimbursement(request);
            }
        }
    }
}
