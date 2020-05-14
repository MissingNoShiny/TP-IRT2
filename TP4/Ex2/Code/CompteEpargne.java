public class CompteEpargne extends Compte {

    private double interets;

    public CompteEpargne(double solde, String denomination, double interets) {
        super(solde, denomination);
        this.interets = interets;
    }

    public CompteEpargne(String denomination, double interets) {
        this(0.0, denomination, interets);
    }

    public void calculerInterets() {
        solde *= interets;
    }
}
