package Composite;

public abstract class MenuComponent {

    protected String name;

    public abstract void add(MenuComponent menuComponent);

    public abstract void print();

    public String getname() {
        return name;
    }
}
