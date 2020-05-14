public class CompteEpargne extends Compte {

    private float interets;

    public CompteEpargne(float solde, String denomination) {
        super(solde, denomination);
    }

    public CompteEpargne(String denomination) {
        super(denomination);

    }

    public void calculerInterets() {
        solde *= interets;
    }
}
