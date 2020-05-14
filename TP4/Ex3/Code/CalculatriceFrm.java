import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CalculatriceFrm extends JFrame {
    public CalculatriceFrm() {
        Calculatrice calculatrice = new Calculatrice();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout());

        //Ecran
        JPanel screenPanel = new JPanel();
        screenPanel.setLayout(new BoxLayout(screenPanel, BoxLayout.Y_AXIS));
        JTextField operation = new JTextField();
        operation.setHorizontalAlignment(SwingConstants.RIGHT);
        operation.setEditable(false);
        screenPanel.add(operation);
        JTextField resultat = new JTextField();
        resultat.setHorizontalAlignment(SwingConstants.RIGHT);
        resultat.setEditable(false);
        screenPanel.add(resultat);
        mainPanel.add(screenPanel, BorderLayout.NORTH);

        //Boutons
        CalculatriceObserveur calculatriceObserveur = new CalculatriceObserveur() {
            @Override
            public void update(ActionEvent e) {
                String label = e.getActionCommand();
                if (label.equals("C")) {
                    calculatrice.resetOperation();
                    operation.setText("");
                } else if (label.equals("=")) {
                    resultat.setText(Double.toString(calculatrice.evaluateOperation()));
                } else {
                    if (!resultat.getText().isEmpty()) {
                        calculatrice.resetOperation();
                        operation.setText("");
                        resultat.setText("");
                    }
                    calculatrice.addChar(label);
                    operation.setText(calculatrice.getOperation());
                }
            }
        };

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        String buttons = "789/456*123-0C=+";
        for (String s : buttons.split("")) {
            JButton button = new JButton(s);
            button.setPreferredSize(new Dimension(60, 40));
            button.addActionListener(calculatriceObserveur::update);
            buttonPanel.add(button);
        }
        mainPanel.add(buttonPanel);

        setContentPane(mainPanel);
        setTitle("Calculatrice");
        pack();
        setVisible(true);
    }
}
