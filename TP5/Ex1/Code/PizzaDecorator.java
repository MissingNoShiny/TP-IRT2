public abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;
    protected String description;
    protected double price;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String afficheDescription() {
        return pizza.afficheDescription() + " " + description;
    }

    @Override
    public double calculePrix() {
        return pizza.calculePrix() + price;
    }
}
