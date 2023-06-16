import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PlayerShip {
    JPanel ship1, ship2, ship3,ship4, ship5;
    Random rand;
    public static void putPlayerShip(JFrame fr,JLabel ship, int x,int y) {
        //this.ship1= new GameGUI().ship1;
        //rand=new Random();
        //ship1 = new JPanel();
        //JLabel p = new JLabel(new ImageIcon("src/images/icon.png"));
        //int xShip1= rand.nextInt(500);
        // int yShip1=rand.nextInt(700);
        ship.setSize(50, 50);
        ship.setLocation(x, y);
        ship.setBackground(Color.WHITE);
        fr.add(ship);

    }
    public void playerFirstMove(JLabel ship) {
        int xP;
        int yP;
        rand = new Random();
        do {
            xP = rand.nextInt(9);
            yP = rand.nextInt(9);

        } while (xP == 0 || yP == 0);

        xP = xP * 50 + 50;
        yP = (8 - yP) * 50 + 100;
        ship.setLocation(xP, yP);
    }
        public static void removeShip(JFrame fr,JLabel ship){
            fr.remove(ship);
        }
        public static int xship(JLabel ship) {
            int xShip=ship.getX();
            return xShip;
        }
    public static int yship(JLabel ship) {
        int yShip=ship.getY();
        return yShip;
    }
    public static boolean isEnemyHit(JLabel ship, int x, int y){
            x=(8-x)*50+510;
            y=(8-y)*50+100;
            if (x==xship(ship) && y==yship(ship)){
                return true;
            }
            else {
                return false;

            }

    }
}
