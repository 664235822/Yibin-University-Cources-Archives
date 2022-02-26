package Menmento;

import java.util.ArrayList;
import java.util.List;

public class Originator {

    private List<String> states = new ArrayList<String>();

    private int index = -1;

    public Memento createMemento() {
        return new Memento(states, index);
    }

    public void restoreMemento(Memento memento) {
        states = memento.getStates();
        index = memento.getIndex();
    }

    public void setState(String state) {
        states.add(state);
        index++;
    }

    @Override
    public String toString() {
        System.out.println(states.get(index));
        return "";
    }
}
