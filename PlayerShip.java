import javax.swing.*;
import java.awt.*;
import java.util.Random;

// This methods represents the player's ships in the game.
// It contains methods for placing and managing player ships on the game board.
public class PlayerShip {

    // Panels representing the player's ships.
    JPanel ship1, ship2, ship3,ship4, ship5;

    // For generating random numbers.
    Random rand;

    // This method is used to place a player ship on the game board.
    public static void putPlayerShip(JFrame fr,JLabel ship, int x,int y) {
        ship.setSize(50, 50);
        ship.setLocation(x, y);
        ship.setBackground(Color.WHITE);
        fr.add(ship);

    }

    // This method is used to set the initial position of the player ship.
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

    // This method is used to remove a ship from the game frame.
        public static void removeShip(JFrame fr,JLabel ship){
            fr.remove(ship);
        }

        // This methods are used to get the x and y coordinates of a ship.
        public static int xship(JLabel ship) {
            int xShip=ship.getX();
            return xShip;
        }
        public static int yship(JLabel ship) {
            int yShip=ship.getY();
            return yShip;
    }

    // This method is used to check if an enemy ship has been hit by the player.
    public static boolean isEnemyHit(JLabel ship, int x, int y){
            x=(8-x)*50+510;
            y=(8-y)*50+100;

            // If the coordinates match the position of the ship, it indicates a hit and true is returned. Otherwise, it indicates a miss and false is returned.

            if (x==xship(ship) && y==yship(ship)){
                return true;
            }
            else {
                return false;

            }
    }
}
