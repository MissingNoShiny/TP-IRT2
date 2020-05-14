import java.util.ArrayList;

public class TestRepertoire {
    public static void main(String[] args) {
        ArrayList<Listable> contenu = new ArrayList<>();
        contenu.add(new Fichier("wow"));
        contenu.add(new Fichier("quoi ?!!"));
        ArrayList<Listable> contenu2 = new ArrayList<>();
        contenu2.add(new Fichier("Un fichier"));
        contenu.add(new Repertoire("doiseer", contenu2));
        Repertoire repertoire = new Repertoire("Repertoire", contenu);
        System.out.println(repertoire.listerFichiers());
    }
}
