package Decorator;

public class DarkRoast extends Coffee {

    private final int DARKROAST_PRICE = 20;

    public DarkRoast() {
        description = "Dark Roast";
    }

    @Override
    public int cost() {
        return DARKROAST_PRICE;
    }
}
