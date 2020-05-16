public class ThermometreControleur {
    private ThermometreModele thermometreModele;

    public ThermometreControleur(ThermometreModele thermometreModele) {
        this.thermometreModele = thermometreModele;
    }

    public void increaseTemperature() {
        thermometreModele.setTemperature(Math.min(30, thermometreModele.getTemperature() + 1));
    }

    public void decreaseTemperature() {
        thermometreModele.setTemperature(Math.max(10, thermometreModele.getTemperature() - 1));
    }
}
