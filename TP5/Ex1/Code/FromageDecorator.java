public class FromageDecorator extends PizzaDecorator {
    public FromageDecorator(Pizza pizza) {
        super(pizza);
        description = "fromage";
        price = 1;
    }
}
