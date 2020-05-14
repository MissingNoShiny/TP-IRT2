public class Facture {
    private float montant;
    private StrategiePrix strategie;

    public Facture(float montant, StrategiePrix strategie) {
        this.montant = montant;
        this.strategie = strategie;
    }

    @Override
    public String toString() {
        return strategie.afficher(montant);
    }
}
