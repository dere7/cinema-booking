import javax.swing.*;
import javax.swing.text.html.Option;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
public class NewMovie extends  JPanel{

    private static JLabel titleLabel, ratingLabel, genreLabel, storyLabel, timeLabel, coverpicLabel, priceLabel, log;
    private static JTextField title, story_line, time, price;
    private static JButton button, coverpic;
    private static JPasswordField Password;
    private static Container cont;
    private static ImageIcon image, image1;

    NewMovie(DB db) {

        setBackground(new Color(0x74FFFFFF, true));
        setLocation(100, 130);
        setSize(300, 400);
        setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(mainPanel);
        log = new JLabel("Add new Movie", JLabel.CENTER);
        log.setFont(new Font(Font.SERIF, Font.BOLD , 24));
        log.setForeground(new Color(0x3B99FF));
        add(log, BorderLayout.NORTH);
        UIManager.put("Label.font", new Font(Font.MONOSPACED, Font.BOLD, 14));
        titleLabel = new JLabel("Title: ");
        mainPanel.add(titleLabel);
        title = new JTextField(20);
        mainPanel.add(title);

        ratingLabel = new JLabel("Rating:");
        mainPanel.add(ratingLabel);
        JSlider rating = new JSlider(0, 10, 5);
        rating.setPaintTicks(true);
        rating.setSnapToTicks(true);
        rating.setMajorTickSpacing(1);
        rating.setPaintLabels(true);
        mainPanel.add(rating);

        genreLabel = new JLabel("Genre:              ");
        mainPanel.add(genreLabel);
        JComboBox<String> genre = new JComboBox<>();
        genre.addItem("Action");
        genre.addItem("Horror");
        genre.addItem("Comedy");
        genre.addItem("Sci-fi");
        genre.addItem("Adventure");
        genre.addItem("Crime");
        genre.addItem("Romance");
        genre.setSize(240, 70);
        mainPanel.add(genre);

        storyLabel = new JLabel("Story: ");
        mainPanel.add(storyLabel);
        JTextArea story = new JTextArea(4, 20);
        mainPanel.add(new JScrollPane(story));

        timeLabel = new JLabel("Time:  ");
        mainPanel.add(timeLabel);
        time = new JTextField(20);
        mainPanel.add(time);

        coverpicLabel = new JLabel("Cover Pic: ");
        mainPanel.add(coverpicLabel);
        coverpic = new JButton("Upload Cover Picture");
        coverpic.addActionListener((ActionEvent actionEvent) -> {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File f = fileChooser.getSelectedFile();
                    try {
                        String uniqueFileName = System.currentTimeMillis() +  "-" + f.getName();
                        String dest = "assets/" + uniqueFileName;
                        FileInputStream is = new FileInputStream(f);
                        FileOutputStream os = new FileOutputStream(dest);
                        byte[] buffer = new byte[1024];
                        int length;
                        while((length = is.read(buffer)) > 0) {
                            os.write(buffer, 0, length);
                        }
                        coverpic.setText(uniqueFileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        });
        mainPanel.add(coverpic);

        priceLabel = new JLabel("Price: ");
        mainPanel.add(priceLabel);
        price = new JTextField(20);
        mainPanel.add(price);

        button = new JButton("Submit");
        button.addActionListener((ActionEvent actionEvent) -> {
                Movie mv = new Movie(
                        title.getText(),
                        (String)genre.getSelectedItem(),
                        story_line.getText(),
                        coverpic.getText(),
                        rating.getValue(),
                        Float.parseFloat(price.getText()),
                        time.getText()
                );
                db.addMovie(mv);
        });
        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        submitPanel.add(button);
        add(submitPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
}
