
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Methods to declare the instance variables.
public class Button {
    // JButton objects representing various buttons in the GUI.
    JButton buttonStart, buttonFire,buttonStop,buttonPause, buttonReplay,buttonConfirm;

    // JLabel objects representing labels for the X and Y coordinates.
    JLabel fireX,fireY;

    // JTextField objects representing text fields for entering X and Y coordinates.
    JTextField fireXTF,fireYTF;

    // JComboBox object representing a drop-down list for selecting a ship.
    JComboBox shipList;

    // This method is responsible for creating and configuring buttons and adding them to the provided JFrame object (fr).
    public void putButton(JFrame fr) {
        // Sets their properties (size, location, text, and background color), and adds them to the frame.
        buttonStart = new JButton();
        buttonFire = new JButton();
        buttonPause = new JButton();
        buttonReplay = new JButton();
        buttonStart.setSize(80, 30);
        buttonStart.setLocation(400, 560);
        buttonStart.setText("START");
        buttonStart.setBackground(Color.ORANGE);
        buttonFire.setSize(80, 30);
        buttonFire.setLocation(280, 560);
        buttonFire.setText("FIRE");
        buttonFire.setBackground(Color.red);
        buttonPause.setText("PAUSE");
        buttonPause.setSize(80, 30);
        buttonPause.setLocation(520, 560);
        buttonPause.setBackground(Color.ORANGE);
        buttonStop = new JButton();
        buttonStop.setSize(80, 30);
        buttonStop.setLocation(400, 560);
        buttonStop.setText("STOP");
        buttonStop.setBackground(Color.ORANGE);
        buttonReplay.setText("REPLAY");
        buttonReplay.setSize(80, 30);
        buttonReplay.setLocation(520, 560);
        buttonReplay.setBackground(Color.ORANGE);
        fr.add(buttonStart);
        fr.add(buttonFire);
        fr.add(buttonPause);

    }
    // This method is responsible for creating components related to firing coordinates (X and Y) and ship selection. Later it will be added to the frame.
    public void fireBoardXY(JFrame fr) {
        fireX = new JLabel();
        fireY = new JLabel();
        fireX.setText("X :");
        fireY.setText("Y: ");
        fireX.setSize(20, 25);
        fireY.setSize(20, 25);
        fireXTF = new JTextField();
        fireYTF = new JTextField();
        fireX.setLocation(50, 540);
        fireY.setLocation(50, 570);
        //fireBoardY.setSize(50,30);
        fireXTF.setLocation(80, 540);
        fireYTF.setLocation(80, 570);
        //fireBoardX.setSize(50,30);

        fireXTF.setSize(45, 25);
        fireYTF.setSize(45, 25);
        String [] shipData={"P1", "P2", "P3","P4", "P5"};
        shipList=new JComboBox(shipData);
        shipList.setSize(50,25);
        shipList.setLocation(150,550);

        // It also creates a "Confirm" button (buttonConfirm) and adds an action listener to it.

        buttonConfirm = new JButton("Confirm");
        buttonConfirm.setSize(100, 20);
        buttonConfirm.setLocation(250, 550);
        fr.add(buttonConfirm);
        fr.add(fireXTF);
        fr.add(fireYTF);
        fr.add(fireX);
        fr.add(fireY);
        fr.add(shipList);
        buttonConfirm.addActionListener(new ActionListener() {

            // When the "Confirm" button is clicked, the selected ship data from the ship list is retrieved,
            // and the X and Y labels, input fields, and confirm button are remove.
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String shipData = (String)cb.getSelectedItem();
                //fireEnemy();
                fr.remove(fireX);
                fr.remove(fireY);
                fr.remove(fireXTF);
                fr.remove(fireYTF);
                fr.remove(buttonConfirm);
                fr.add(buttonFire);
                System.out.println(" Ship to fire is ship "+ shipData);
            }
        });
    }
}
