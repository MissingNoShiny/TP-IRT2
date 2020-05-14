import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BanqueFrm extends JFrame {

    public BanqueFrm() {
        Banque banque = new Banque();
        banque.addCompte(new CompteCourant("compte courant"));
        banque.addCompte(new CompteEpargne("compte epargne", 1.05));
        banque.addCompte(new ComptePayant("compte payant"));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        //Ligne 1
        JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ligne1.add(new JLabel("Montant "));
        JTextField montantField = new JTextField(10);
        montantField.setText("0");
        ligne1.add(montantField);
        mainPanel.add(ligne1);

        //Ligne 2
        JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ligne2.add(new JLabel("Compte "));
        JComboBox<Compte> compteComboBox = new JComboBox<>(banque.collectionComptes().toArray(new Compte[0]));
        ligne2.add(compteComboBox);
        mainPanel.add(ligne2);

        //Ligne 3
        JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ligne3.add(new JLabel("Transaction "));
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton depotButton = new JRadioButton("Dépôt");
        buttonGroup.add(depotButton);
        depotButton.setSelected(true);
        ligne3.add(depotButton);
        JRadioButton retraitButton = new JRadioButton("Retrait");
        buttonGroup.add(retraitButton);
        ligne3.add(retraitButton);
        mainPanel.add(ligne3);

        //Ligne 4
        JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton validerButton = new JButton("Valider");
        ligne4.add(validerButton);
        JButton interetsButton = new JButton("Calculer les intérêts");
        ligne4.add(interetsButton);
        interetsButton.setVisible(false);
        mainPanel.add(ligne4);

        JTextArea historique = new JTextArea(7, 30);
        JScrollPane scrollPane = new JScrollPane(historique);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        mainPanel.add(scrollPane);

        //Observeurs
        Observeur interetsButtonObserver = new Observeur() {
            @Override
            public void update() {
                interetsButton.setVisible(compteComboBox.getSelectedItem() instanceof CompteEpargne);
            }
        };
        compteComboBox.addActionListener(actionEvent -> interetsButtonObserver.update());

        Observeur validerObserver = new Observeur() {
            @Override
            public void update() {
                double montant = 0;
                try {
                    montant = Double.parseDouble(montantField.getText());
                } catch (NumberFormatException e) {
                    montantField.setText("0");
                    return;
                }
                Compte compte = (Compte) compteComboBox.getSelectedItem();
                assert compte != null;
                if (depotButton.isSelected()) compte.ajouterMontant(montant);
                else compte.retirerMontant(montant);
                historique.append(String.format("%s : solde = %f\n", compte.toString(), compte.getSolde()));
                montantField.setText("0");
            }
        };
        validerButton.addActionListener(actionEvent -> validerObserver.update());

        Observeur calculerInteretsObserveur = new Observeur() {
            @Override
            public void update() {
                if (!(compteComboBox.getSelectedItem() instanceof CompteEpargne)) return;
                CompteEpargne compte = (CompteEpargne)compteComboBox.getSelectedItem();
                assert compte != null;
                compte.calculerInterets();
                historique.append(String.format("%s : solde = %f\n", compte.toString(), compte.getSolde()));
            }
        };
        interetsButton.addActionListener(actionEvent -> calculerInteretsObserveur.update());

        add(mainPanel);
        setTitle("Self banking");
        pack();
        setVisible(true);
    }
}

