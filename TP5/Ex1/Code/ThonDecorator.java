public class ThonDecorator extends PizzaDecorator {
    public ThonDecorator(Pizza pizza) {
        super(pizza);
        description = "thon";
        price = 2;
    }

    @Override
    public String afficheDescription() {
        return super.afficheDescription() + " thon";
    }

    @Override
    public double calculePrix() {
        return super.calculePrix() + 2;
    }
}
