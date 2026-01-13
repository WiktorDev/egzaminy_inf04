import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Enumeration;

public class MainFrame extends JFrame {
    private JPanel contentPane;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JTextField lastNameField;
    private JTextField nameField;
    private JTextField numberField;
    private JButton okButton;
    private JLabel image1;
    private JLabel image2;

    private ButtonGroup radioButtonGroup;

    public MainFrame() {
        setTitle("Wprowadzenie danych do paszportu. Wykonał: 00000000000");
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
//        setResizable(false);
        setVisible(true);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButton1);
        radioButtonGroup.add(radioButton2);
        radioButtonGroup.add(radioButton3);
        radioButtonGroup.setSelected(radioButton1.getModel(), true);

        okButton.addActionListener(e -> {
            if (nameField.getText().isEmpty() || lastNameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Wprowadź dane", "Brak danych", JOptionPane.WARNING_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(
                    null,
                    String.format("%s %s kolor oczu %s", nameField.getText(), lastNameField.getText(), getEyeColor()),
                    "test",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        numberField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                ImageIcon fingerPrintIcon = new ImageIcon(MainFrame.class.getResource(String.format("%s-odcisk.jpg", numberField.getText())));
                ImageIcon avatarIcon = new ImageIcon(MainFrame.class.getResource(String.format("%s-zdjecie.jpg", numberField.getText())));
                image1.setIcon(avatarIcon);
                image2.setIcon(fingerPrintIcon);
            }
        });
    }

    public String getEyeColor() {
        if (radioButtonGroup.getSelection() == null) return null;
        for (Enumeration<AbstractButton> buttons = radioButtonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) return button.getText();
        }
        return null;
    }


    public static void main(String[] args) {
        new MainFrame();
    }
}
