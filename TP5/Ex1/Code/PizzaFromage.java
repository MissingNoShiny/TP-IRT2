public class PizzaFromage implements Pizza {
    @Override
    public String afficheDescription() {
        return "Pizza fourrée au fromage";
    }

    @Override
    public double calculePrix() {
        return 8;
    }
}
