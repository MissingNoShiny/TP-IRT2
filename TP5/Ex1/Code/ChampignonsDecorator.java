public class ChampignonsDecorator extends PizzaDecorator {
    public ChampignonsDecorator(Pizza pizza) {
        super(pizza);
        description = "champignons";
        price = 0.5;
    }
}
