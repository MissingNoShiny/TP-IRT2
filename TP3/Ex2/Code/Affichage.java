public abstract class Affichage {

    protected StationMeteo station;
    public Affichage(StationMeteo station) {
        this.station = station;
    }
    public abstract void update();
}
