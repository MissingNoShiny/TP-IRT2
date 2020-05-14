import java.util.ArrayList;

public class StationMeteo {

    private ArrayList<Affichage> affichages = new ArrayList<>();
    private ArrayList<Integer> temperatures = new ArrayList<>();
    private int humidite;

    public void ajouterDonnees(int temperature, int humidite) {
        temperatures.add(temperature);
        this.humidite = humidite;
        notifyAllObservers();
    }

    public void addObservateur(Affichage affichage) {
        affichages.add(affichage);
    }

    private void notifyAllObservers() {
        System.out.println("----------------------------------------");
        for (Affichage affichage : affichages)
            affichage.update();
    }

    public ArrayList<Integer> getTemperatures() {
        return temperatures;
    }

    public int getHumidite() {
        return humidite;
    }
}
