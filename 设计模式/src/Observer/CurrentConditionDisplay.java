package Observer;

public class CurrentConditionDisplay implements Observer {

    private float temperature, humidity, cleanness;

    private Subject envData;

    public CurrentConditionDisplay(Subject envdata) {
        this.envData = envdata;
        envData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float cleanness) {
        this.temperature = temp;
        this.humidity = humidity;
        this.cleanness = cleanness;

        System.out.println("温度：" + temperature + ",湿度：" + humidity + ",洁净度：" + cleanness);
    }
}
