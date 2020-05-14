public class CompteCourant extends Compte {
    public CompteCourant(float solde, String denomination) {
        super(solde, denomination);
    }

    public CompteCourant(String denomination) {
        super(denomination);
    }

    @Override
    public void retirerMontant(float montant) {
        solde -= montant * 1.05;
    }
}
