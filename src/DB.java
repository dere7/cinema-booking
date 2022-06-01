import java.sql.*;
import java.util.ArrayList;

public class DB {
    public Connection conn;
    public Statement stmt;

    public DB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/cinema_db", "cinema_user", "cinema_pwd");
            stmt = conn.createStatement();
            // ResultSet rs = stmt.executeQuery("SELECT * FROM user");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public ArrayList<Movie> getMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM movie");

            while (rs.next()) {
                Movie mv = new Movie(
                        rs.getString("title"), rs.getString("genre"), rs.getString("story_line"),
                        rs.getString("cover_pic"), rs.getFloat("rating"), rs.getFloat("price"),
                        rs.getTime("time").toString());
                movies.add(mv);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return movies;
    }

    public Movie getMovie(int id) {
        Movie mv = null;
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM movie WHERE id = " + id);
            rs.next();
            mv = new Movie(
                    rs.getString("title"), rs.getString("genre"), rs.getString("story_line"),
                    rs.getString("cover_pic"), rs.getFloat("rating"), rs.getFloat("price"),
                    rs.getTime("time").toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return mv;
    }

    public void addMovie(Movie mv) {
        try {
            PreparedStatement stmt;
            stmt = conn.prepareStatement(
                    "INSERT INTO movie (title, genre, story_line, cover_pic, rating, price, time) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, mv.title);
            stmt.setString(2, mv.genre);
            stmt.setString(3, mv.storyline);
            stmt.setString(4, mv.cover_pic);
            stmt.setFloat(5, mv.rating);
            stmt.setFloat(6, mv.price);
            stmt.setString(7, mv.time);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
