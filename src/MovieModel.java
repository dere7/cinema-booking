import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MovieModel extends AbstractTableModel {

    static String[] cols = {
            "id", "title", "genre", "storyline", "cover_pic", "rating", "price", "time"
    };

    private DB db;
    private ArrayList<Movie> movies;

    MovieModel() {
        db = new DB();
        movies = db.getMovies();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return null;
    }

}
