import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class EnemyShip {
   // JPanel shipE1, shipE2,shipE3,shipE4,shipE5;
    Random rand;
    public static void putEnemyShip(JFrame fr, JLabel shipE, int x,int y) {
       // shipE1 = new JPanel();
        shipE.setSize(50, 50);
        shipE.setBackground(Color.WHITE);
        shipE.setLocation(x, y);
        //JLabel e1 = new JLabel(new ImageIcon("src/images/kapal.jpg"));
        fr.add(shipE);
        //shipE1.add(e1);

    }
    public void enemyFirstMove(JLabel shipE) {
        int xP;
        int yP;
        rand = new Random();
        do {
            xP = rand.nextInt(9);
            yP = rand.nextInt(9);

        } while (xP == 0 || yP == 0);

        xP = (8 - xP) * 50 + 510;
        yP = (8 - yP) * 50 + 100;
        shipE.setLocation(xP, yP);
        System.out.println("ship1 : X" + xP + "   Y: " + yP);}

    public static boolean isPlayerHit(JLabel ship,int x,int y){
        x= x * 50 + 50;
        y = (8 - y) * 50 + 100;
        if (x== PlayerShip.xship(ship) && y== PlayerShip.yship(ship)){
            return true;
        }
        else {
            return false;

        }

    }
    public void moveEnemy(JLabel shipE){
        int x;
        int y;
        rand = new Random();
        do {
            x = rand.nextInt(9);
            y = rand.nextInt(9);

        } while (x == 0 || y == 0);
        x = (8 - x) * 50 + 510;
        y = (8 - y) * 50 + 100;
        shipE.setLocation(x, y);

    }

}
