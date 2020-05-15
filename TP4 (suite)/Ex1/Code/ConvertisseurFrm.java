import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
        taxeField.setEnabled(false);
        ligne2.add(taxeField);
        ligne2.add(new JLabel("%"));
        mainPanel.add(ligne2);

        //Observeurs
        RadioButtonObserveur radioButtonObserveur = new RadioButtonObserveur() {
            @Override
            public void update() {
                boolean taxeMode = taxeButton.isSelected();
                taxeField.setEnabled(taxeMode);
                topLabel.setText(taxeMode ? "HT" : "EUR");
                bottomLabel.setText(taxeMode ? "TTC" : "USD");
                topField.setText("");
                bottomField.setText("");
            }
        };
        montantButton.addActionListener(actionEvent -> radioButtonObserveur.update());
        taxeButton.addActionListener(actionEvent -> radioButtonObserveur.update());

        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                update(documentEvent);
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                update(documentEvent);
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) { }

            private void update(DocumentEvent documentEvent) {
                Runnable doUpdate = () -> {
                    double rate = 0;
                    try {
                        rate = taxeButton.isSelected() ? Double.parseDouble(taxeField.getText()) : 8;
                    } catch (NumberFormatException e) {
                        return;
                    }
                    if (documentEvent.getDocument() == topField.getDocument() && topField.hasFocus()) {
                        try {
                            double value = Double.parseDouble(topField.getText());
                            bottomField.setText(value + value * rate / 100 + "");
                        } catch (NumberFormatException ignored) { }
                    } else if (documentEvent.getDocument() == bottomField.getDocument() && bottomField.hasFocus()) {
                        try {
                            double value = Double.parseDouble(bottomField.getText());
                            topField.setText(value - value * rate / 100 + "");
                        } catch (NumberFormatException ignored) { }
                    }
                };
                SwingUtilities.invokeLater(doUpdate);
            }
        };
        topField.getDocument().addDocumentListener(documentListener);
        bottomField.getDocument().addDocumentListener(documentListener);

        setContentPane(mainPanel);
        setTitle("Convertisseur");
        pack();
        setVisible(true);
    }
}
