package State;

public class SoldOutState implements State {

    private TissueMachine tissueMachine;

    public SoldOutState(TissueMachine tissueMachine){
        this.tissueMachine=tissueMachine;
    }

    @Override
    public void insertQuarter(){
        System.out.println("机器吴纸巾，已退回硬币");
    }

    @Override
    public void ejectQuarter(){
        System.out.println("自动售货机没有硬币");
    }

    @Override
    public void turnCrank(){
        System.out.println("机器无纸巾，请不要操作");
    }

    @Override
    public void dispense(){

    }
}
