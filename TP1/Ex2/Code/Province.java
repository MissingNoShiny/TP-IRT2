import java.util.ArrayList;

public class Province implements Profitable {

    public ArrayList<Ville> villes;

    public Province(ArrayList<Ville> villes) {
        this.villes = villes;
    }

    @Override
    public int getBenefice() {
        return villes.stream().mapToInt(Ville::getBenefice).sum();
    }
}
