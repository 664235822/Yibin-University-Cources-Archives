package ChainOfResponsibility;

public class CFO extends Reimbursement {

    public CFO(String name) {
        super(name);
    }

    @Override
    public void requestForReimbursement(Proposer request) {
        if (request.getAmount() < 20000) {
            System.out.println(("报销金额为：" + request.getAmount() + ",被【" + name + "】报销了"));
        } else if (request.getAmount() < 50000) {
            System.out.println(("过来喝喝茶，聊一聊"));
        } else {
            System.out.println(("金额超过50000，被【" + name + "】拒绝报销"));
        }
    }
}
