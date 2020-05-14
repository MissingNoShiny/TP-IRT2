import javax.swing.*;
import java.awt.*;

public class CompteBancaireFrm extends JFrame {

    private static class AjouteMontantEcouteur {

        private JTextField field;
        private JLabel label;
        private JTextArea area;
        private CompteBancaire compte;

        public AjouteMontantEcouteur(JTextField field, JLabel label, JTextArea area, CompteBancaire compte) {
            this.field = field;
            this.label = label;
            this.area = area;
            this.compte = compte;
        }

        public void update() {
            try {
                compte.depot(Integer.parseInt(field.getText()));
            } catch (NumberFormatException e) {
                field.setText("0");
                return;
            }
            field.setText("0");
            label.setText(String.format("Votre solde = %d", (int) compte.getSolde()));
            area.append(String.format("%d \n", (int) compte.getSolde()));
        }
    }

    private AjouteMontantEcouteur ecouteur;

    public CompteBancaireFrm(String title, CompteBancaire compte) {
        super(title);
        setPreferredSize(new Dimension(450, 100));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setPreferredSize(getSize());

        JLabel montant = new JLabel("Montant : ");
        mainPanel.add(montant);

        JTextField montantInput = new JTextField(5);
        montantInput.setText("0");
        mainPanel.add(montantInput);

        JLabel montantLabel = new JLabel();
        mainPanel.add(montantLabel);

        JTextArea area = new JTextArea(3, 4);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        ecouteur = new AjouteMontantEcouteur(montantInput, montantLabel, area, compte);

        JButton button = new JButton("Ajouter montant");
        button.addActionListener(actionEvent -> ecouteur.update());
        mainPanel.add(button);
        mainPanel.add(scroll);

        ecouteur.update();
        add(mainPanel);
        pack();
        setVisible(true);
    }
}
