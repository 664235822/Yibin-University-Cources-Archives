package Menmento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    private Originator originator;
    private List<Memento> mementos = new ArrayList<Memento>();
    private int current = -1;

    public Caretaker(Originator originator) {
        this.originator = originator;
    }

    public int createMemento() {
        Memento memento = originator.createMemento();
        mementos.add(memento);
        return ++current;
    }

    public void restoreMemeto(int index) {
        if (index > current)
            return;

        Memento memento = mementos.get(index);
        originator.restoreMemento(memento);
    }
}
