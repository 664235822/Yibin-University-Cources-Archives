package Composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {

    private List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();

    public Menu(String name) {
        this.name = name;
    }

    @Override
    public void add(MenuComponent menucomponent) {
        menuComponents.add(menucomponent);
    }

    @Override
    public void print() {
        System.out.println(name);
        System.out.println("-------------------");
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            menuComponent.print();
        }
        System.out.println("-------------------");
    }
}
