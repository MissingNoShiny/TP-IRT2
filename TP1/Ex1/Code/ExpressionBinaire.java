public class ExpressionBinaire implements Calculable {
    private Calculable gauche;
    private Calculable droite;
    private Operateur operateur;

    public ExpressionBinaire(Calculable gauche, Calculable droite, Operateur operateur) {
        this.gauche = gauche;
        this.droite = droite;
        this.operateur = operateur;
    }

    @Override
    public int calculer() {
        int reponse = gauche.calculer();
        switch (operateur) {
            case ADDITION:
                reponse += droite.calculer();
                break;
            case SOUSTRACTION:
                reponse -= droite.calculer();
                break;
            case MULTIPLICATION:
                reponse *= droite.calculer();
                break;
        }
        return reponse;
    }

    @Override
    public String toString() {
        return "(" + gauche.toString() +  operateur.toString() + droite.toString() + ")";
    }
}
