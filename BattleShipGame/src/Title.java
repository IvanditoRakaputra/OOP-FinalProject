import javax.swing.*;
import java.awt.*;

public class Title {
    JPanel title;
    public void putTitle(JFrame fr) {
        title = new JPanel();
        title.setSize(1010, 30);
        title.setLocation(0, 0);
        fr.add(title);
        JLabel labelTitle = new JLabel();
        labelTitle.setText("Battleship Game Field");
        title.add(labelTitle);
        title.setBackground(Color.MAGENTA);


    }
}
