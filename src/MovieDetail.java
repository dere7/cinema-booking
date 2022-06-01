import javax.swing.*;
import java.awt.*;

public class MovieDetail extends JPanel{
    public MovieDetail(Movie mv) {
        // draw
        setPreferredSize(new Dimension(70, 290));
        setLayout(null);
        // create widgets
        JLabel title = new JLabel(mv.title);

        JLabel ratingGenre = new JLabel(String.format("<html><i>%.1f/10 - %s</i></html>", mv.rating, mv.genre));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));
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

        JLabel priceTime = new JLabel(String.format("<html><b>Price %.2f - Time %s</b></html>", mv.price, mv.time));
        JButton book = new JButton("Book");
        title.setFont(new Font("Open Sans Regular", Font.BOLD, 24));

        // position widgets
        coverPic.setBounds(20, 20, 185, 250);
        add(coverPic);
        title.setBounds(230, 20, 400, 30);
        add(title);
        ratingGenre.setBounds(230, 50, 400, 30);
        add(ratingGenre);
         storyLine.setBounds(230, 80, 400, 150);
        add(storyLine);
         priceTime.setBounds(230, 230, 200, 30);
        add(priceTime);
         book.setBounds(440, 230, 200, 30);
        add(book);
    }
}
