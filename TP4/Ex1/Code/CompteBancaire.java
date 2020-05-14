public class CompteBancaire {
    private double solde;

    public CompteBancaire(double solde) {
        this.solde = Math.max(0.0, solde);
    }

    public void depot(double montant) {
        solde += Math.max(0.0, montant);
    }

    public double getSolde() {
        return solde;
    }
}
