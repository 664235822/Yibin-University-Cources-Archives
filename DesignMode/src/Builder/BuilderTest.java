package Builder;

public class BuilderTest {
    public static void main(String[] args) {
        // write your code here

        Waiter waiter1 = new Waiter();
        PizzaBuilder hpb = new HawaiianPizzaBuilder();
        waiter1.setPizzaBuilder(hpb);
        waiter1.construct();

        System.out.println("Pizza："+waiter1.getPizza().getParts());

        Waiter waiter2 = new Waiter();
        PizzaBuilder spb = new SpicyPizzaBuilder();
        waiter2.setPizzaBuilder(spb);
        waiter2.construct();

        System.out.println("Pizza："+waiter2.getPizza().getParts());
    }
}
