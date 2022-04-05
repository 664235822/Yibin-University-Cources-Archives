package State;

public class HasQuarterState implements State {

    private TissueMachine tissueMachine;

    public HasQuarterState(TissueMachine tissueMachine){
        this.tissueMachine=tissueMachine;
    }

    @Override
    public void insertQuarter(){
        System.out.println("已投币，请不要重复投币");
    }

    @Override
    public void ejectQuarter(){
        tissueMachine.setState(tissueMachine.getNoQuarterState());
        System.out.println("自动售货机没有硬币");
    }

    @Override
    public void turnCrank(){
        tissueMachine.setState(tissueMachine.getSoldState());
        System.out.println("请等待出纸巾");
    }

    @Override
    public void dispense(){

    }
}
