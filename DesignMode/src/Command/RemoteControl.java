package Command;

public class RemoteControl {

    private Command[] onCommands=new Command[2];

    private Command[] offCommands=new Command[2];

    public RemoteControl(){}

    public void setCommand(int slot,Command onCommand,Command offCommand){
        onCommands[slot]=onCommand;
        offCommands[slot]=offCommand;
    }

    public void onButtonWasPushed(int slot){
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot){
        offCommands[slot].execute();
    }
}
