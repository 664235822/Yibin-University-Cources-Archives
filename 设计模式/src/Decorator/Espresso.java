package Decorator;

public class Espresso extends Coffee{

    private final int ESPRESSO_PRICE=25;

    public Espresso(){
        description="Espresso Coffee";
    }

    @Override
    public int cost(){
        return ESPRESSO_PRICE;
    }
}
