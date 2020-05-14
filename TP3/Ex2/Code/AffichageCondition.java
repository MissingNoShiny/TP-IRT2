public class AffichageCondition extends Affichage {
    public AffichageCondition(StationMeteo station) {
        super(station);
    }

    @Override
    public void update() {
        int temperature = station.getTemperatures().get(station.getTemperatures().size() - 1);
        int humidite = station.getHumidite();
        System.out.print(String.format("Températures : %d°C - Humidité : %d%% >> ", temperature, humidite));;
    }
}
