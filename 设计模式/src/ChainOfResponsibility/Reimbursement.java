package ChainOfResponsibility;

public abstract class Reimbursement {

    protected String name;

    protected Reimbursement nextHandler;

    public Reimbursement(String name) {
        this.name = name;
    }

    public abstract void requestForReimbursement(Proposer request);

    public void setNextHandler(Reimbursement nextHandler) {
        this.nextHandler = nextHandler;
    }
}
