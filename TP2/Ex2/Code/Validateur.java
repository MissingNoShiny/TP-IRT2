public class Validateur {

    private Format format;
    private String txt;

    public Validateur(Format format, String txt) {
        this.format = format;
        this.txt = txt;
    }

    public boolean isValide() {
        return format.isValide(txt);
    }
}
