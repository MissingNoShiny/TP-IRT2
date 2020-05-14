public abstract class Compte {
    protected double solde;
    protected String denomination;

    public Compte(double solde, String denomination) {
        this.solde = solde;
        this.denomination = denomination;
    }

    public Compte(String denomination) {
        this(0.0, denomination);
    }

    public void ajouterMontant(float montant) {
        solde += montant;
    }

    public void retirerMontant(float montant) {
        solde -= montant;
    }
}
