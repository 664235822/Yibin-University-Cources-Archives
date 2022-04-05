package Composite;

public class MenuItem extends MenuComponent {

    private int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        return;
    }

    @Override
    public void print() {
        System.out.println(name + "的价格为" + price + "元");
    }
}
