public class ThermometreModele {
    private ThermometreObserveur observeur;
    private int temperature;

    public ThermometreModele() {
        temperature = 20;
    }

    public void setObserveur(ThermometreObserveur observeur) {
        this.observeur = observeur;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        observeur.update();
    }

    public int getTemperature() {
        return temperature;
    }
}
