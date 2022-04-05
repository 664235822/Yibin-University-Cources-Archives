package Command;

public class CommandTest {

    public static void main(String[] args) {
        // write your code here

        Light livingRoomLight=new Light("客厅");
        Light bathRoomLight =new Light("卧室");

        LightOnCommand livingRoomLightOnCommand =new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOffCommand=new LightOffCommand(livingRoomLight);

        LightOnCommand bathRoomLightOnCommand =new LightOnCommand(bathRoomLight);
        LightOffCommand bathRoomLightOffCommand=new LightOffCommand(bathRoomLight);

        RemoteControl remoteControl=new RemoteControl();
        remoteControl.setCommand(0,livingRoomLightOnCommand,livingRoomLightOffCommand);
        remoteControl.setCommand(1,bathRoomLightOnCommand,bathRoomLightOffCommand);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(1);
    }
}