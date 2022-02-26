package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class UnsharedConcreteFlyweight implements Flyweight {

    private Map<Character, Flyweight> mapFlyweights = new HashMap<Character, Flyweight>();

    public void add(Character key, Flyweight flyweight) {
        mapFlyweights.put(key, flyweight);
    }

    @Override
    public void operation(String state) {
        Flyweight flyweight = null;
        for (Object key : mapFlyweights.keySet()) {
            flyweight = mapFlyweights.get(key);
            flyweight.operation(state);
        }
    }
}
