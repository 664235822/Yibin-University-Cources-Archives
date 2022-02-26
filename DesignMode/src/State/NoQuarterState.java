package State;

public class NoQuarterState implements State {

    private TissueMachine tissueMachine;

    public NoQuarterState(TissueMachine tissueMachine){
        this.tissueMachine=tissueMachine;
    }

    @Override
    public void insertQuarter(){
        tissueMachine.setState(tissueMachine.getHasQuarterState());
        System.out.println("已投币");
    }

    @Override
    public void ejectQuarter(){
        System.out.println("自动售货机没有硬币");
    }

    @Override
    public void turnCrank(){
        System.out.println("请投币");
    }

    @Override
    public void dispense(){

    }
}
