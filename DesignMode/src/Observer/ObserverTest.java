package Observer;

public class ObserverTest {

    public static void main(String[] args) {
        // write your code here

        EnvironmentData envData=new EnvironmentData();
        CurrentConditionDisplay curDisplay=new CurrentConditionDisplay(envData);

        envData.setMeasurements(40,65,30.4f);

        envData.notifyObserver();
    }
}