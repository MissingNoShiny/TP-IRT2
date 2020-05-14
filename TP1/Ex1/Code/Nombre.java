public class Nombre implements Calculable {
    private int value;

    public Nombre(int value) {
        this.value = value;
    }

    @Override
    public int calculer() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
