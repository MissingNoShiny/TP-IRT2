public class OignonsDecorator extends PizzaDecorator {
    public OignonsDecorator(Pizza pizza) {
        super(pizza);
        description = "oignons";
        price = 0.5;
    }
}
