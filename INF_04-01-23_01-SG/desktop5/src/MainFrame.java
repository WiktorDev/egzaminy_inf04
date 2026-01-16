import javax.swing.*;
import java.util.Random;

public class MainFrame extends JFrame {
    private JPanel contentPane;
    private JButton confirmButton;
    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField passwordLengthInput;
    private JCheckBox hasBigLetters;
    private JCheckBox hasDigits;
    private JCheckBox hasSpecialChars;
    private JButton generatePasswordButton;
    private JComboBox comboBox1;

    private String password = "";

    public MainFrame() {
        setTitle("Dodaj pracownika. Autor: 00000000000");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setVisible(true);

        generatePasswordButton.addActionListener(e -> {
            this.password = this.generatePassword();
            JOptionPane.showMessageDialog(null, this.password);
        });

        confirmButton.addActionListener(e -> JOptionPane.showMessageDialog(
                null,
                String.format(
                        "Dane pracownika: %s %s %s Hasło: %s",
                        nameField.getText(),
                        lastNameField.getText(),
                        comboBox1.getSelectedItem(),
                        this.password
                )
        ));
    }

    private String generatePassword() {
        Random random = new Random();
        int length = Integer.parseInt(passwordLengthInput.getText());
        String smallLetters = "abcdefghijklmnopqrstuvwxyz";
        String bigLetters = smallLetters.toUpperCase();
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()_+-=";

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(smallLetters.charAt(random.nextInt(smallLetters.length())));
        }

        if (hasBigLetters.isSelected()) {
            int index = random.nextInt(password.length());
            password.setCharAt(index, bigLetters.charAt(random.nextInt(bigLetters.length())));
        }

        if (hasDigits.isSelected()) {
            int index = random.nextInt(password.length());
            password.setCharAt(index, numbers.charAt(random.nextInt(numbers.length())));
        }

        if (hasSpecialChars.isSelected()) {
            int index = random.nextInt(password.length());
            password.setCharAt(index, specialChars.charAt(random.nextInt(specialChars.length())));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
