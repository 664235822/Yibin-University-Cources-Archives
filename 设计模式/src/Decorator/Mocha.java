package Decorator;

public class Mocha extends CondimentDecorator {

    private final int MOCHA_PRICE = 10;

    public Mocha(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int cost() {
        return MOCHA_PRICE + this.coffee.cost();
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + "," + "Mocha";
    }
}
