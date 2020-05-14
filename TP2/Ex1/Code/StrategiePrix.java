@FunctionalInterface
public interface StrategiePrix {
    public String afficher(float montant);

    static StrategiePrix be() {
        return montant -> "Le montant de la facture est : " + montant + " €";
    }

    static StrategiePrix de() {
        return montant -> "Der Rechnungbetrag ist : € " + montant;
    }

    static StrategiePrix uk() {
        return montant -> "The amount of the invoice is: £" + montant;
    }
}