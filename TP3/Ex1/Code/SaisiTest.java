import java.util.Scanner;

public class SaisiTest {
    public static void main(String[] args) {
        Saisi saisi=new Saisi();
        ConvBin convB=new ConvBin();
        ConvHex convH=new ConvHex();
        ConvOctale convO=new ConvOctale();
        saisi.add(convO);
        saisi.add(convB);
        saisi.add(convH);
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Saisir un entier :");
            saisi.setNombre(sc.nextInt());
        }
    }
}
