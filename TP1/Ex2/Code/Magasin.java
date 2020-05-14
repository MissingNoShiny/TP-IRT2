public class Magasin implements Profitable {

    private int benefice;

    public Magasin(int benefice) {
        this.benefice = benefice;
    }

    @Override
    public int getBenefice() {
        return benefice;
    }
}
