import java.io.Serializable;

public class Movie implements Serializable {
    public String title, genre, cover_pic, storyline;
    public float rating, price;
    public String time;
    public int id;

    public Movie(String title, String genre, String storyline, String cover_pic, float rating, float price,
            String time) {
        // this.id = id;
        this.title = title;
        this.genre = genre;
        this.cover_pic = cover_pic;
        this.storyline = storyline;
        this.rating = rating;
        this.price = price;
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("<Movie[%d] %s - %.2f>", this.id, this.title, this.rating);
    }

    public String[] getCols() {
        return new String[]{"id", "title", "genre", "storyline", "rating", "price", "time"};
    }

}
