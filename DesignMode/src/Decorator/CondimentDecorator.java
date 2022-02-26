package Decorator;

public class CondimentDecorator extends Coffee {

    @Override
    public int cost(){
        return 0;
    }

    Coffee coffee;
}
