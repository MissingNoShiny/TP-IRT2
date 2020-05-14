import java.util.ArrayList;
import java.util.stream.Collectors;

public class Repertoire implements Listable {
    private String name;
    private ArrayList<Listable> contenu;

    public Repertoire(String name, ArrayList<Listable> contenu) {
        this.name = name;
        this.contenu = contenu;
    }

    @Override
    public String listerFichiers() {
        return this.name + ": ("
                + contenu.stream().map(Listable::listerFichiers).collect(Collectors.joining(", ")) + ")";
    }
}
