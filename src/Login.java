import javax.swing.*;

import java.awt.*;

public class Login extends JFrame {
    private static JLabel password1, label, log;
    private static JTextField username;
    private static JButton button;
    private static JPasswordField Password;

    Login() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        setTitle("YCINEMA");
        ImageIcon image = new ImageIcon("src/assets/cinema1.jpg");
        setIconImage(image.getImage());
        // frame.setLocation(new Point(500, 300));
        log = new JLabel("Welcome to Y CINEMA Login Page");
        log.setBounds(50, 10, 300, 20);
        panel.add(log);

        add(panel);
        setSize(new Dimension(400, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);

        label = new JLabel("Username");
        label.setBounds(10, 30, 70, 20);
        panel.add(label);

        username = new JTextField();
        username.setBounds(10, 50, 190, 28);
        panel.add(username);

        password1 = new JLabel("Password");
        password1.setBounds(10, 80, 70, 20);
        panel.add(password1);

        Password = new JPasswordField();
        Password.setBounds(10, 100, 190, 28);
        panel.add(Password);

        button = new JButton("Login");
        button.setBounds(10, 135, 90, 25);
        button.setForeground(new Color(115, 184, 88));
        button.setBackground(new Color(22, 11, 110));

        panel.add(button);
        setVisible(true);
    }

}
