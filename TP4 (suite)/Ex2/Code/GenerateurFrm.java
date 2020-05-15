import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GenerateurFrm extends JFrame {
    public GenerateurFrm() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JLabel hexLabel = new JLabel("Lorem Ispum");

        JPanel slidersPanel = new JPanel(new GridLayout(1, 3));
        Color[] color = {Color.RED, Color.GREEN, Color.BLUE};
        String[] colorNames = {"Rouge", "Vert", "Bleu"};
        JSlider[] colorSliders = {null, null, null};

        GenerateurObserveur generateurObserveur = new GenerateurObserveur() {
            @Override
            public void update() {
                String hexString = Arrays.stream(colorSliders).map(s -> String.format("%02X", s.getValue())).collect(Collectors.joining());
                hexLabel.setText("0x" + hexString);
                hexLabel.setBackground(Color.decode("#" + hexString));
            }
        };

        for (int i = 0; i < 3; i++) {
            JPanel colorPanel = new JPanel();
            colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.Y_AXIS));
            JLabel colorLabel = new JLabel(colorNames[i]);
            colorLabel.setOpaque(true);
            colorLabel.setBackground(color[i]);
            colorPanel.add(colorLabel);
            JSlider colorSlider = new JSlider(JSlider.VERTICAL, 0, 255, 0);
            colorPanel.add(colorSlider);
            colorSliders[i] = colorSlider;
            JSpinner colorSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 255, 1));
            JSpinner.DefaultEditor editor = new JSpinner.DefaultEditor(colorSpinner);
            colorSpinner.setEditor(editor);
            JFormattedTextField formattedTextField = editor.getTextField();
            formattedTextField.setColumns(3);
            colorPanel.add(colorSpinner);
            colorSlider.addChangeListener(changeEvent -> {
                colorSpinner.setValue(colorSlider.getValue());
                generateurObserveur.update();
            });
            colorSpinner.addChangeListener(changeEvent ->  {
                colorSlider.setValue((int) colorSpinner.getValue());
                generateurObserveur.update();
            });
            slidersPanel.add(colorPanel);
        }
        mainPanel.add(slidersPanel);

        JPanel hexPanel = new JPanel();
        hexPanel.add(new JLabel("Hex ="));
        hexLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
        hexLabel.setOpaque(true);
        hexPanel.add(hexLabel);
        generateurObserveur.update();
        mainPanel.add(hexPanel);

        setContentPane(mainPanel);
        setTitle("Convertisseur");
        pack();
        setVisible(true);
    }
}
