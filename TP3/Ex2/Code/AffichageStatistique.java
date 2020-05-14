public class AffichageStatistique extends Affichage {
    public AffichageStatistique(StationMeteo station) {
        super(station);
    }

    @Override
    public void update() {
        int max = station.getTemperatures().stream().max(Integer::compare).orElse(0);
        int min = station.getTemperatures().stream().min(Integer::compare).orElse(0);
        int average = (int) station.getTemperatures().stream().mapToDouble(a -> a).average().orElse(0);
        System.out.println(String.format("Temperatures min/max/moy : %d°C/ %d°C/ %d°C", min, max, average));
    }
}
