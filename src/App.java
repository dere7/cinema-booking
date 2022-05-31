import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        JPanel newMovie = new NewMovie(db);
        tabbedPane.addTab("List of Movies", movies);
        tabbedPane.addTab("Add Movie", newMovie);
        add(tabbedPane);
        setVisible(true);
    }

}
