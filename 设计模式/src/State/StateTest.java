package State;

public class StateTest {

    public static void main(String[] args) {
        // write your code here

        TissueMachine machine=new TissueMachine(1);

        machine.insertQuarter();
        machine.ejectQuarter();
        machine.turnCrank();

        machine.insertQuarter();
        machine.turnCrank();
        
        machine.turnCrank();
    }
}