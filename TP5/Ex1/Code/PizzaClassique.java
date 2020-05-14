public class PizzaClassique implements Pizza {
    @Override
    public String afficheDescription() {
        return "Pizza classique";
    }

    @Override
    public double calculePrix() {
        return 7;
    }
}
