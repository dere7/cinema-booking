import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Admin extends JPanel {
    public Admin(DB db) throws SQLException {
        JLabel title = new JLabel("Admin Inteface");
        title.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        title.setForeground(new Color(0x3B99FF));
        add(title);

        String query = "SELECT id, title, genre, story_line, rating, price, time FROM movie ORDER BY time";
        JTable table = new JTable(new ResultSetTableModel(db, query));
        add(table);
    }
}
