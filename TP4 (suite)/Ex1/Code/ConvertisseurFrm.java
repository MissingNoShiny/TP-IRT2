import javax.swing.*;
import java.awt.*;

public class ConvertisseurFrm extends JFrame {
    public ConvertisseurFrm() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        //Ligne 1
        JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField topField = new JTextField(12);
        topField.setHorizontalAlignment(SwingConstants.RIGHT);
        ligne1.add(topField);
        JLabel topLabel = new JLabel("EUR");
        ligne1.add(topLabel);
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton montantButton = new JRadioButton("Montant");
        buttonGroup.add(montantButton);
        montantButton.setSelected(true);
        ligne1.add(montantButton);
        JRadioButton taxeButton = new JRadioButton("Taxe");
        buttonGroup.add(taxeButton);
        ligne1.add(taxeButton);
        mainPanel.add(ligne1);

        //Ligne 2
        JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField bottomField = new JTextField(12);
        bottomField.setHorizontalAlignment(SwingConstants.RIGHT);
        ligne2.add(bottomField);
        JLabel bottomLabel = new JLabel("USD");
        ligne2.add(bottomLabel);
        JTextField taxeField = new JTextField("21", 3);
        ligne2.add(taxeField);
        ligne2.add(new JLabel("%"));
        mainPanel.add(ligne2);

        setContentPane(mainPanel);
        setTitle("Convertisseur");
        pack();
        setVisible(true);
    }
}
