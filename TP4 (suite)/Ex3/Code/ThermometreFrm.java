import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ThermometreFrm extends JFrame {
    public ThermometreFrm() {
        //Affichage
        JFrame affichage = new JFrame();
        JPanel affichagePanel = new JPanel();
        JLabel affichageLabel = new JLabel("20°C");
        affichageLabel.setFont(new Font("Comic sans MS", Font.BOLD, 80));
        affichagePanel.add(affichageLabel);
        affichagePanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        affichage.setContentPane(affichagePanel);
        affichage.pack();
        affichage.setTitle("Affichage");
        affichage.setDefaultCloseOperation(EXIT_ON_CLOSE);
        affichage.setVisible(true);

        //Thermometre
        Font font = new Font("Comic sans MS", Font.PLAIN, 35);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel ligne1 = new JPanel(new FlowLayout());
        JTextField temperatureField = new JTextField("20");
        temperatureField.setHorizontalAlignment(SwingConstants.RIGHT);
        temperatureField.setEditable(false);
        temperatureField.setFont(font);
        ligne1.add(temperatureField);
        JLabel degreLabel = new JLabel("°C");
        degreLabel.setHorizontalAlignment(SwingConstants.LEFT);
        degreLabel.setFont(font);
        ligne1.add(degreLabel);
        mainPanel.add(ligne1);
        JPanel ligne2 = new JPanel(new FlowLayout());
        JButton moinsButton = new JButton("-");
        moinsButton.setFont(font);
        ligne2.add(moinsButton);
        JButton plusButton = new JButton("+");
        plusButton.setFont(font);
        ligne2.add(plusButton);
        mainPanel.add(ligne2);
        JPanel validerPanel = new JPanel();
        JButton validerButton = new JButton("Valider");
        validerButton.setFont(font);
        validerPanel.add(validerButton);
        mainPanel.setBorder(new EmptyBorder(0, 50, 0, 50));
        mainPanel.add(validerPanel);

        //MVC
        ThermometreModele thermometreModele = new ThermometreModele();
        ThermometreObserveur thermometreObserveur = () -> temperatureField.setText(thermometreModele.getTemperature() + "");
        thermometreModele.setObserveur(thermometreObserveur);
        ThermometreControleur thermometreControleur = new ThermometreControleur(thermometreModele);
        moinsButton.addActionListener(actionEvent -> thermometreControleur.decreaseTemperature());
        plusButton.addActionListener(actionEvent -> thermometreControleur.increaseTemperature());
        validerButton.addActionListener(actionEvent -> affichageLabel.setText(String.format("%d°C", thermometreModele.getTemperature())));

        setTitle("Thermomètre");
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

}
