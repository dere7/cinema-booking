import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MoviesList  extends JPanel{
    public MoviesList(DB db) {
        setBackground(Color.white);
        ArrayList<Movie> movies = db.getMovies();
        setLayout(new GridLayout(movies.size(), 1));
        for (Movie movie : movies) {
            add(new MovieDetail(movie));
        }
        setVisible(true);
    }
}
