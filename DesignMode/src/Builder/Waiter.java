package Builder;

public class Waiter {

    private PizzaBuilder pizzaBuilder;

    public void construct() {
        pizzaBuilder.createNewPizza();
        pizzaBuilder.buildParts();
    }

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }
}
