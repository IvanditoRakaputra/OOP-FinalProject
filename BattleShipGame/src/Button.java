import com.sun.source.util.Plugin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button {
    JButton buttonStart, buttonFire,buttonStop,buttonPause, buttonReplay,buttonConfirm;
    JLabel fireX,fireY;
    JTextField fireXTF,fireYTF;
    JComboBox shipList;

    public void putButton(JFrame fr) {
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
        /**
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Button Start is Pressed");
                PlayerShip ps=new PlayerShip();
                ps.playerFirstMove();
                EnemyShip es=new EnemyShip();
                es.enemyFirstMove();
                //enemyMove();
               // playerFirstMove();

                fr.remove(buttonStart);
                fr.add(buttonStop);
                //enemyMotion();
            }
        });
        buttonPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button pause is pressed");
                fr.remove(buttonPause);
                fr.add(buttonReplay);
            }
        });
        buttonFire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button fire is pressed");
                fireBoardXY(GameGUI.fr);
                fr.remove(buttonFire);
            }
        });
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // putPlayerShip();
                //putEnemyShip();
                fr.remove(buttonStop);
                fr.add(buttonStart);
            }
        });
        buttonReplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.remove(buttonReplay);
                fr.add(buttonPause);
            }
        });
         **/


    }
    public void fireBoardXY(JFrame fr) {
        //fireBoardX=new JPanel();
        // fireBoardY=new JPanel();
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
        //fireBoardX.add(fireXTF);
        // fireBoardY.add(fireYTF);
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
