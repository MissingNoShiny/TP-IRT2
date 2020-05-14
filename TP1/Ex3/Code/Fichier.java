public class Fichier implements Listable {

    private String name;

    public Fichier(String name) {
        this.name = name;
    }

    @Override
    public String listerFichiers() {
        return this.name;
    }
}
