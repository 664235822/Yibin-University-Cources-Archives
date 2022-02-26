package Composite;

public class CompositeTest {

    public static void main(String[] args) {
        // write your code here

        MenuComponent menuComponent = new Menu("ALL MENU");
        MenuComponent menu1 = new Menu("MENU1");
        MenuComponent menu2 = new Menu("MENU2");
        MenuComponent item1 = new MenuItem("item1", 8);
        MenuComponent item2 = new MenuItem("item2", 13);
        MenuComponent item3 = new MenuItem("item3", 6);
        MenuComponent item4 = new MenuItem("item4", 14);
        MenuComponent item5 = new MenuItem("item5", 27);
        MenuComponent item6 = new MenuItem("item6", 10);

        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);

        menu2.add(item4);
        menu2.add(item5);
        menu2.add(item6);

        menuComponent.add(menu1);
        menuComponent.add(menu2);

        menuComponent.print();
    }
}