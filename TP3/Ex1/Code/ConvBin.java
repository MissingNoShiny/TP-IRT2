public class ConvBin extends Convertisseur {
    @Override
    public void update(int valeur) {
        System.out.println("Conversion en binaire : " + Integer.toBinaryString(valeur));
    }
}
