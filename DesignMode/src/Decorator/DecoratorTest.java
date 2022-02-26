package Decorator;

public class DecoratorTest {

    public static void main(String[] args) {
        // write your code here

        Coffee coffee=new DarkRoast();
        System.out.println(coffee.getDescription()+" " +coffee.cost());
        coffee=new Mocha(coffee);
        System.out.println(coffee.getDescription()+" " +coffee.cost());
        coffee=new Whip(coffee);
        System.out.println(coffee.getDescription()+" " +coffee.cost());
        coffee=new Whip(coffee);
        System.out.println(coffee.getDescription()+" " +coffee.cost());
    }
}