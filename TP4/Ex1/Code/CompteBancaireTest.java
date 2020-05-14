public class CompteBancaireTest {
    public static void main(String[] args) {
        CompteBancaire compte = new CompteBancaire(100);
        new CompteBancaireFrm("Compte Bancaire", compte);
    }
}
