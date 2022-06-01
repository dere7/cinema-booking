import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class App extends JFrame {
    public DB db;

    public App() {
        db = new DB();
        setLocation(30, 30);
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        // changes default font for labels and text area
        UIManager.put("Label.font", new Font("Open Sans Regular", Font.PLAIN, 14));
        UIManager.put("TextArea.font", new Font("Open Sans Regular", Font.PLAIN, 14));
        // add UI
        setTitle("Black Lion Cinema");
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel movies = new MoviesList(db);
        JScrollPane scrollPane = new JScrollPane(movies, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        try {
            tabbedPane.addTab("Admin", new Admin(db));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        tabbedPane.addTab("List of Movies", scrollPane);
        tabbedPane.addTab("Add Movie", new NewMovie(db));

        add(tabbedPane);
        // pack();
        setVisible(true);
    }
}
