public class TestFacture {
    public static void main(String[] args) {
        Facture facture1 = new Facture(20, StrategiePrix.be());
        System.out.println(facture1);
        Facture facture2 = new Facture(40, StrategiePrix.de());
        System.out.println(facture2);
        Facture facture3 = new Facture(30, StrategiePrix.uk());
        System.out.println(facture3);
    }
}
