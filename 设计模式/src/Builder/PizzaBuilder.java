package Builder;

abstract class PizzaBuilder {

    protected Pizza pizza;

    public void createNewPizza() {
        pizza = new Pizza();
    }

    abstract void buildParts();

    public Pizza getPizza() {
        return pizza;
    }
}
