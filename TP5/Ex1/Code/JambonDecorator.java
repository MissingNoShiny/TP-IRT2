public class JambonDecorator extends PizzaDecorator {
    public JambonDecorator(Pizza pizza) {
        super(pizza);
        description = "jambon";
        price = 1;
    }
}
