public class PizzaTest {
    public static void main(String[] args) {
        Pizza pizza1 = new JambonDecorator(new FromageDecorator(new ChampignonsDecorator(new PizzaClassique())));
        System.out.println(pizza1.afficheDescription());
        System.out.println(pizza1.calculePrix());
    }
}
