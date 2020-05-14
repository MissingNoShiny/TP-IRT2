public class StationMeteoTest {
    public static void main(String[] args) {
        StationMeteo sm=new StationMeteo();
        AffichageCondition ac=new AffichageCondition(sm);
        AffichageStatistique as=new AffichageStatistique(sm);

        sm.addObservateur(ac);
        sm.addObservateur(as);

        sm.ajouterDonnees(20, 50);
        sm.ajouterDonnees(25, 65);
        sm.ajouterDonnees(27, 70);
    }
}
