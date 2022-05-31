import javax.swing.*;
import java.awt.*;

public class MovieDetail extends JPanel{
    public MovieDetail(Movie mv) {
        // draw
        // setLocation(100, 120);
        setSize(600, 250);
        setLayout(null);

        // create widgets
        JLabel title = new JLabel(mv.title);
        JLabel ratingGenre = new JLabel(String.format("%.1f/10 - %s", mv.rating, mv.genre));

        ImageIcon img = new ImageIcon("src/" + mv.cover_pic);
        Image scaledImage = img.getImage().getScaledInstance(185, 250,Image.SCALE_DEFAULT);
        img.setImage(scaledImage);
        JLabel coverPic = new JLabel(img);

        JTextArea storyLine = new JTextArea(mv.storyline);
        storyLine.setLineWrap(true);
        storyLine.setWrapStyleWord(true);
        storyLine.setEditable(false);
        storyLine.setAutoscrolls(true);
        storyLine.setBackground(getBackground());

        JLabel priceTime = new JLabel(String.format("Price %.2f - Time %s", mv.price, mv.time));
        JButton book = new JButton("Book");
        title.setFont(new Font("Open Sans Regular", Font.BOLD, 24));

        // position widgets
        coverPic.setBounds(0, 0, 185, 250);
        add(coverPic);
        title.setBounds(210, 0, 400, 30);
        add(title);
        ratingGenre.setBounds(210, 30, 400, 30);
        add(ratingGenre);
         storyLine.setBounds(210, 60, 400, 150);
        add(storyLine);
         priceTime.setBounds(210, 210, 200, 30);
        add(priceTime);
         book.setBounds(410, 210, 200, 30);
        add(book);
    }
}
