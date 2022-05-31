import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMovie {
    private JPanel panel1;
    private JButton addButton;
    private JButton clearButton;
    private JPanel MainForm;
    private JTextField textField1;
    private JTextField textField2;

    public AddMovie() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Created Movie successfully");
            }
        });
    }

}
