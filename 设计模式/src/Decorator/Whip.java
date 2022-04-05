package Decorator;

public class Whip extends CondimentDecorator {

    private final int WHIP_PRICE = 5;

    public Whip(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int cost() {
        return WHIP_PRICE + this.coffee.cost();
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + "," + "Whip";
    }
}
