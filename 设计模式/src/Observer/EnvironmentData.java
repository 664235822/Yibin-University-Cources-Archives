package Observer;

import java.util.ArrayList;

public class EnvironmentData implements Subject {

    private ArrayList<Observer> observers;

    private float temperature,humidity,cleanness;

    public EnvironmentData(){
        observers=new ArrayList<Observer>();
    }

    public void setMeasurements(float temp,float humodity,float cleanness){
        this.temperature=temp;
        this.humidity=humodity;
        this.cleanness=cleanness;
    }

    @Override
    public void registerObserver(Observer observer){
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(){
        for(int i=0;i<observers.size();i++){
            observers.get(i).update(temperature,humidity,cleanness);
        }
    }

}
