import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MoviesList  extends JPanel{
    public MoviesList(DB db) {
        // setPreferredSize(new Dimension(650, 250));
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);
        ArrayList<Movie> movies = db.getMovies();
        for (Movie movie : movies) {
            add(new MovieDetail(movie));
        }
        setVisible(true);
    }
}
