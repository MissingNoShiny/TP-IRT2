import java.util.ArrayList;

public class Saisi {

    int valeur;
    ArrayList<Convertisseur> convertisseurs = new ArrayList<>();

    public Saisi() {

    }

    public void add(Convertisseur conv) {
        convertisseurs.add(conv);
    }

    public void setNombre(int nombre) {
        valeur = nombre;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Convertisseur conv : convertisseurs)
            conv.update(valeur);
    }
}
