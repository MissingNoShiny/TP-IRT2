public class BoulettesDecorator extends PizzaDecorator {
    public BoulettesDecorator(Pizza pizza) {
        super(pizza);
        description = "boulettes";
        price = 2;
    }
}
