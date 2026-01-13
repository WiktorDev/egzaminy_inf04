import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainFrame extends JFrame {
    private JPanel contentPane;
    private JTextField keyInput;
    private JTextArea plainTextInput;
    private JButton encryptButton;
    private JButton saveEncryptedButton;
    private JLabel encryptedText;

    public MainFrame() {
        setTitle("Szyfrowanie. Wykonane przez 00000000000");
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        encryptButton.addActionListener(e -> {
            int key;
            try {
                key = Integer.parseInt(keyInput.getText());
            } catch (NumberFormatException ex) {
                key = 0;
            }

            encryptedText.setText(this.encrypt(plainTextInput.getText(), key));
        });

        saveEncryptedButton.addActionListener(event -> {
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            fileChooser.setSelectedFile(new File("encrypted_text.txt"));

            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
                    writer.write(encryptedText.getText());
                    JOptionPane.showMessageDialog(null, "Plik został zapisany:\n" + selectedFile.getAbsolutePath());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Błąd podczas zapisywania pliku: " + e.getMessage());
                }
            }
        });
    }

    public String encrypt(String plainText, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            if (c >= 'a' && (int)c <= 'z') encrypted.append((char) ('a' + (c - 'a' + key) % 26));
            else encrypted.append(c);
        }
        return encrypted.toString();
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
