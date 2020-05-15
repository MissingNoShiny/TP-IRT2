import javax.swing.*;
import java.awt.*;

public class ThermometreFrm extends JFrame {
    public ThermometreFrm() {
        //Affichage
        JFrame affichage = new JFrame();
        JPanel affichagePanel = new JPanel();
        JLabel affichageLabel = new JLabel("0°C");
        affichagePanel.add(affichageLabel);
        affichage.setContentPane(affichagePanel);
        affichagePanel.setPreferredSize(new Dimension(200, 50));
        affichage.pack();
        affichage.setTitle("Affichage");
        affichage.setDefaultCloseOperation(EXIT_ON_CLOSE);
        affichage.setVisible(true);

        setTitle("Thermomètre");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
