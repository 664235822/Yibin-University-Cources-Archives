package Flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyweightFactory {

    private Map<Character, Flyweight> flyweightsMap = new HashMap<Character, Flyweight>();

    public Flyweight getFlyweight(List<Character> stateList) {
        UnsharedConcreteFlyweight flyweight = new UnsharedConcreteFlyweight();

        for (Character state : stateList) {
            flyweight.add(state, this.getFlyweight(state));
        }
        return flyweight;
    }

    public Flyweight getFlyweight(Character state) {
        Flyweight flyweight = flyweightsMap.get(state);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(state);
            flyweightsMap.put(state, flyweight);
        }
        return flyweight;
    }
}
