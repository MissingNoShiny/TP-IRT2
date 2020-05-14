import java.util.ArrayList;

public class Banque {

    private ArrayList<Compte> lesComptes = new ArrayList<>();

    public void addCompte(Compte compte) {
        lesComptes.add(compte);
    }

    public Compte getCompte(int index) {
        return lesComptes.get(index);
    }

    public ArrayList<Compte> collectionComptes() {
        return lesComptes;
    }
}
