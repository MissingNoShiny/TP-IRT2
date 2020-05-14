public class ExpressionBinaireTest {
    public static void main(String[] args) {
        ExpressionBinaire test1 = new ExpressionBinaire(new Nombre(4), new Nombre(5), Operateur.ADDITION);
        ExpressionBinaire test2 = new ExpressionBinaire(new Nombre(2), new Nombre(4), Operateur.MULTIPLICATION);
        ExpressionBinaire test3 = new ExpressionBinaire(test1, test2, Operateur.SOUSTRACTION);
        System.out.println(test3 + " = " + test3.calculer());
    }
}
