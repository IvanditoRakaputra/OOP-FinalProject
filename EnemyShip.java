import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Represents the enemy ship in the game.
// This method is responsible for placing an enemy ship on the game board.
public class EnemyShip implements Interface{

    // This is a Random object used for generating random numbers.
    Random rand;
    // JFrame object (fr), a JLabel object (shipE) representing the ship, and the coordinates (x and y) where the ship should be placed.
    public static void putEnemyShip(JFrame fr, JLabel shipE, int x,int y) {
       // shipE1 = new JPanel();
        shipE.setSize(50, 50);
        shipE.setBackground(Color.WHITE);
        shipE.setLocation(x, y);
        fr.add(shipE);
    }
    // This method is responsible for the initial movement of the enemy ship.
    public void enemyFirstMove(JLabel shipE) {
        int xP;
        int yP;
        rand = new Random();

        // generates random X and Y coordinates within the range [1, 8] (excluding 0).

        do {
            xP = rand.nextInt(9);
            yP = rand.nextInt(9);

        } while (xP == 0 || yP == 0);

        // The ship label is then moved to the generated coordinates, and the updated position is printed to the console.
        xP = (8 - xP) * 50 + 510;
        yP = (8 - yP) * 50 + 100;
        shipE.setLocation(xP, yP);
        System.out.println("ship1 : X" + xP + "   Y: " + yP);}

// Checks if the player's shot hit the enemy ship.
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

    //This method is responsible for moving the enemy ship to a new random position.
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
