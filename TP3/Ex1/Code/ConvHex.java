public class ConvHex extends Convertisseur {
    @Override
    public void update(int valeur) {
        System.out.println("Conversion en Hex : " + Integer.toHexString(valeur));
    }
}
