public class OlivesDecorator extends PizzaDecorator {
    public OlivesDecorator(Pizza pizza) {
        super(pizza);
        description = "olives";
        price = 0.5;
    }
}
