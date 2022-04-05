package State;

public class SoldState implements State {

    private TissueMachine tissueMachine;

    public SoldState(TissueMachine tissueMachine) {
        this.tissueMachine = tissueMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("请等待出纸巾");
    }

    @Override
    public void ejectQuarter() {
        tissueMachine.setState(tissueMachine.getNoQuarterState());
        System.out.println("请等待出纸巾，无法取回已消费的硬币");
    }

    @Override
    public void turnCrank() {
        System.out.println("已出纸巾");
    }

    @Override
    public void dispense() {
        System.out.println("已响应，出纸巾");
        tissueMachine.setCount(tissueMachine.getCount() - 1);
        if (tissueMachine.getCount() == 0) {
            tissueMachine.setState(tissueMachine.getSoldOutState());
        }
    }
}
