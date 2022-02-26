package Interpreter;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private Map<Variable, Integer> map = new HashMap<Variable, Integer>();

    public void assign(Variable var, int value) {
        map.put(var, new Integer(value));
    }

    public int lookup(Variable var) {
        Integer value = map.get(var);
        if (value != null) {
            return value.intValue();
        }
        return 0;
    }
}