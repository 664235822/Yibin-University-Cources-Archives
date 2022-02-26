package Iterator;

public class ContreteIterator extends Iterator {

    private ConcreteAggregate aggregate;

    private int current = 0;

    public ContreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public Object first() {
        return aggregate.at(0);
    }

    @Override
    public Object next() {
        current++;
        if (current < aggregate.count()) {
            return aggregate.at(current);
        }
        return null;
    }

    @Override
    public boolean isDone() {
        return (current >= aggregate.count() ? true : false);
    }

    @Override
    public Object CurrentItem() {
        return aggregate.at(current);
    }
}
