import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private JPanel jpanel;
    private JSlider sliderRed;
    private JSlider sliderGreen;
    private JSlider sliderBlue;
    private JLabel valueRed;
    private JLabel valueGreen;
    private JLabel valueBlue;
    private JButton downloadColorButton;
    private JPanel colorBox;
    private JLabel colorHex;
    private JPanel colorHexBox;

    public MainForm() {
        setTitle("Wzornik kolorów RGB. Wykonal 0000000000");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(jpanel);
        pack();
        setResizable(false);
        setVisible(true);

        sliderRed.setMaximum(255);
        sliderRed.setValue(255);
        sliderGreen.setMaximum(255);
        sliderGreen.setValue(255);
        sliderBlue.setMaximum(255);
        sliderBlue.setValue(255);

        this.updateHexBox();

        sliderRed.addChangeListener(e -> updateColor());
        sliderGreen.addChangeListener(e -> updateColor());
        sliderBlue.addChangeListener(e -> updateColor());

        downloadColorButton.addActionListener(e -> updateHexBox());
    }

    /**
     * bazwa mnetody:       getColor
     * opis metody:         metoda tworzy obiekt Color na podstawie wartości z suwaków
     * parametry:           brak
     * zwracany typ i opis: java.awt.Color - kolor wygenerowany na podstawie suwaków
     * autor:               00000000000
     */
    private Color getColor() {
        return new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue());
    }

    /**
     * bazwa mnetody:       updateHexBox
     * opis metody:         aktualizuje kolor i tekst w małym prostokącie
     * parametry:           brak
     * zwracany typ i opis: brak
     * autor:               00000000000
     */
    private void updateHexBox() {
        colorHex.setText(String.format("%d, %d, %d", sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue()));
        colorHexBox.setBackground(this.getColor());
    }

    /**
     * bazwa mnetody:       updateColor
     * opis metody:         aktualizuje kolor duzego prostokata
     * parametry:           brak
     * zwracany typ i opis: brak
     * autor:               00000000000
     */
    private void updateColor() {
        colorBox.setBackground(this.getColor());
        valueRed.setText(sliderRed.getValue() + "");
        valueGreen.setText(sliderGreen.getValue() + "");
        valueBlue.setText(sliderBlue.getValue() + "");
    }
}
