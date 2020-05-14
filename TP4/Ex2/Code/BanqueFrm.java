import javax.swing.*;
import java.awt.*;

public class BanqueFrm extends JFrame {

    public BanqueFrm() {
        Banque banque = new Banque();
        banque.addCompte(new CompteCourant("compte courant"));
        banque.addCompte(new CompteEpargne("compte epargne"));
        banque.addCompte(new ComptePayant("compte payant"));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        JPanel ligne1 = new JPanel();
        ligne1.setLayout(new FlowLayout());


        pack();
        setVisible(true);
    }
}

