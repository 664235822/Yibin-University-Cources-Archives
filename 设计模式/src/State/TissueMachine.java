package State;

public class TissueMachine {

    private State soldOutState,noQuarterState,hasQuarterState,soldState;

    private int count;

    private State state;

    public TissueMachine(int numbers){
        count=numbers;
        soldOutState=new SoldOutState(this);
        noQuarterState=new NoQuarterState(this);
        hasQuarterState=new HasQuarterState(this);
        soldState=new SoldState(this);
        if(count>0){
            this.state=noQuarterState;
        }
    }

    public void setState(State state){
        this.state=state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int numbers){
        this.count=numbers;
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }

    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }
}
