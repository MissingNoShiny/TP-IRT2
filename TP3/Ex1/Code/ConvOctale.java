public class ConvOctale extends Convertisseur {
    @Override
    public void update(int valeur) {
        System.out.println("Conversion en octal : " + Integer.toOctalString(valeur));
    }
}
