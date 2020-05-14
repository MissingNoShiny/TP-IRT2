public class ComptePayant extends Compte {
    public ComptePayant(float solde, String denomination) {
        super(solde, denomination);
    }
    public ComptePayant(String denomination) {
        super(denomination);
    }

    @Override
    public void ajouterMontant(float montant) {
        solde += montant * 0.95;
    }

    @Override
    public void retirerMontant(float montant) {
        solde -= montant * 1.05;
    }
}
