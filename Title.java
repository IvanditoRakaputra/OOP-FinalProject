import javax.swing.*;
import java.awt.*;

// Responsible for displaying the title of the game at the top of the game frame.
public class Title {
    // Represents the title
    JPanel title;

    // This method is used to place the title panel on the game frame.
    public void putTitle(JFrame fr) {
        title = new JPanel();
        title.setSize(1010, 30);
        title.setLocation(0, 0);
        fr.add(title);
        JLabel labelTitle = new JLabel();
        labelTitle.setText("Battle Ship War Game");
        title.add(labelTitle);
        title.setBackground(Color.ORANGE);
    }
}
