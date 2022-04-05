package Iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate extends Aggregate {

    private List<Object> items = new ArrayList<Object>();

    @Override
    public Iterator createIterator() {
        return new ContreteIterator(this);
    }

    public int count() {
        return items.size();
    }

    public Object at(int index) {
        return items.get(index);
    }

    public void add(int index, Object element) {
        items.add(index, element);
    }
}
