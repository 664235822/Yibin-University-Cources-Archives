package Decorator;

public abstract class Coffee {

    String description="Unknown Coffee";

    public String getDescription() {
        return description;
    }

    public abstract int cost();
}
