public class CompteCourant extends Compte {
    public CompteCourant(double solde, String denomination) {
        super(solde, denomination);
    }

    public CompteCourant(String denomination) {
        super(denomination);
    }

    @Override
    public void retirerMontant(double montant) {
        solde -= montant * 1.05;
    }
}
