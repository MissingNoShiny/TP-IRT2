public class PizzaPateFine implements Pizza {
    @Override
    public String afficheDescription() {
        return "Pizza pâte fine";
    }

    @Override
    public double calculePrix() {
        return 6;
    }
}
