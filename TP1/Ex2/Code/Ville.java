import java.util.ArrayList;

public class Ville implements Profitable {

    public ArrayList<Magasin> magasins;

    public Ville(ArrayList<Magasin> magasins) {
        this.magasins = magasins;
    }

    @Override
    public int getBenefice() {
        return magasins.stream().mapToInt(Magasin::getBenefice).sum();
    }
}
