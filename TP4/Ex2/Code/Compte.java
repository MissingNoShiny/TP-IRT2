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

    public void ajouterMontant(double montant) {
        solde += montant;
    }

    public void retirerMontant(double montant) {
        solde -= montant;
    }

    public double getSolde() {
        return solde;
    }

    @Override
    public String toString() {
        return denomination;
    }
}
