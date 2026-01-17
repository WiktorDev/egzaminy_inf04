import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AppFrame extends JFrame {
    private JPanel panel;
    private JTextField postCodeField;
    private JRadioButton pocztowkaRadioButton;
    private JRadioButton listRadioButton;
    private JRadioButton paczkaRadioButton;
    private JButton checkPriceButton;
    private JButton confirmButton;
    private JLabel selectedIcon;
    private JLabel priceText;

    private ButtonGroup buttonGroup;

    public AppFrame() {
        setTitle("Nadaj Przesyłkę. PESEL: 000000000000");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        Map<String, String> prices = new HashMap<>(){{
            put("pocztowka", "1");
            put("paczka", "10");
            put("list", "1,5");
        }};

        pocztowkaRadioButton.setActionCommand("pocztowka");
        listRadioButton.setActionCommand("list");
        listRadioButton.setSelected(true);
        paczkaRadioButton.setActionCommand("paczka");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(paczkaRadioButton);
        buttonGroup.add(listRadioButton);
        buttonGroup.add(pocztowkaRadioButton);

        checkPriceButton.addActionListener(v -> {
            String key = buttonGroup.getSelection().getActionCommand();
            priceText.setText("Cena: " + prices.get(key) + " zł");
            selectedIcon.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/"+key+".png"))));
        });

        confirmButton.addActionListener(v -> {
            String postCode = postCodeField.getText();
            if (postCode.length() != 5) {
                JOptionPane.showMessageDialog(null, "Niepoprawna liczba cyfr w kodzie pocztowym", "", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!postCode.chars().allMatch(Character::isDigit)) {
                JOptionPane.showMessageDialog(null, "Kod pocztowy powinien sie skladac z samych cyfr", "", JOptionPane.WARNING_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null, "Dane przesyłki zostały wprowadzone!");
        });
    }

    public static void main(String[] args) {
        new AppFrame();
    }
}
