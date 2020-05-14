public class ComptePayant extends Compte {
    public ComptePayant(double solde, String denomination) {
        super(solde, denomination);
    }
    public ComptePayant(String denomination) {
        super(denomination);
    }

    @Override
    public void ajouterMontant(double montant) {
        solde += montant * 0.95;
    }

    @Override
    public void retirerMontant(double montant) {
        solde -= montant * 1.05;
    }
}
