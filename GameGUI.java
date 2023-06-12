import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

// Create the Game GUI Class which consist of several main class
public class GameGUI {
    public static JFrame fr = new JFrame("Battleship");
    JButton buttonStart, buttonFire,buttonStop,buttonPause, buttonResume,buttonConfirm;
    JLabel fireX,fireY;
    JTextField fireXTF,fireYTF;
    JComboBox shipList;
    JLabel ship1,ship2, ship3,ship4,ship5;
    JLabel shipE1,shipE2,shipE3,shipE4,shipE5;
    JLabel playing=new JLabel();
    //JPanel ship1=new JPanel();
    Random random=new Random();
    boolean isPaused=false;
    boolean isStarted=false;
    int enemyNumber=5;
    int playerNumber=5;

    // Initializes the GUI components by calling the initGUI() method.
public GameGUI(){
    initGUI();

}

// Sets up the main JFrame window by configuring its layout, size, title, background color, visibility, and other properties.
    public void initGUI() {
        fr.setLayout(null);
        fr.setBackground(Color.BLUE);
        fr.getContentPane().setBackground(new Color(173, 216, 230));
        fr.setSize(1010, 650);
        fr.getDefaultCloseOperation();
        fr.setVisible(true);
        fr.setResizable(false);
        Title title=new Title();
        title.putTitle(fr);
        putBnd();
        putShip();
        putEnemyShip();
        putScoreLabel();
        putButton();
        putLabel();
        enemyMotion();
        gameOver();

    }
    // Methods for adding boundary
    public void putBnd(){
        Boundary b=new Boundary();
        b.putBoundary(fr);
        b.putBoundary1(fr);
        b.putBoundary2(fr);
        b.putBoundary3(fr);
        b.putBoundary4(fr);
    }

    // Methods for adding player ships
    public void putShip(){
    ship1=new JLabel(new ImageIcon("src/images/icon.png"));
   PlayerShip.putPlayerShip(fr,ship1,100,200);
   ship2=new JLabel(new ImageIcon("src/images/icon.png"));
   PlayerShip.putPlayerShip(fr,ship2,100,250);
   ship3=new JLabel(new ImageIcon("src/images/icon.png"));
   PlayerShip.putPlayerShip(fr,ship3,100,300);
   ship4=new JLabel(new ImageIcon("src/images/icon.png"));
   PlayerShip.putPlayerShip(fr,ship4,100,350);
   ship5=new JLabel(new ImageIcon("src/images/icon.png"));
   PlayerShip.putPlayerShip(fr,ship5,100,400);

    }

    // Methods for adding player enemy ships
    public void putEnemyShip(){
    shipE1=new JLabel(new ImageIcon("src/images/kapal.png"));
    EnemyShip.putEnemyShip(fr,shipE1,860,200);
        shipE2=new JLabel(new ImageIcon("src/images/kapal.png"));
        EnemyShip.putEnemyShip(fr,shipE2,860,250);
        shipE3=new JLabel(new ImageIcon("src/images/kapal.png"));
        EnemyShip.putEnemyShip(fr,shipE3,860,300);
        shipE4=new JLabel(new ImageIcon("src/images/kapal.png"));
        EnemyShip.putEnemyShip(fr,shipE4,860,350);
        shipE5=new JLabel(new ImageIcon("src/images/kapal.png"));
        EnemyShip.putEnemyShip(fr,shipE5,860,400);
    }

    // Adds a score label to the frame by creating an instance of the Score class and calling its putScore() method.
    public void putScoreLabel(){
    Score score = new Score();
    score.putScore(fr);

    }
// Adds buttons to the frame, including "START", "FIRE", "PAUSE", "RESUME", and "STOP" buttons.
        public void putButton() {
            buttonStart = new JButton();
            buttonFire = new JButton();
            buttonPause = new JButton();
            buttonResume = new JButton();
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
            buttonResume.setText("RESUME");
            buttonResume.setSize(80, 30);
            buttonResume.setLocation(520, 560);
            buttonResume.setBackground(Color.ORANGE);
            fr.add(buttonStart);
             buttonStart.addActionListener(new ActionListener() {

                 // the button "start" is performed, the game start. The start button change to "stop"
            @Override
            public void actionPerformed(ActionEvent e) {
            PlayerShip ps=new PlayerShip();
            ps.playerFirstMove(ship1);
                ps.playerFirstMove(ship2);
                ps.playerFirstMove(ship3);
                ps.playerFirstMove(ship4);
                ps.playerFirstMove(ship5);

            EnemyShip es=new EnemyShip();
           es.enemyFirstMove(shipE1);
                es.enemyFirstMove(shipE2);
                es.enemyFirstMove(shipE3);
                es.enemyFirstMove(shipE4);
                es.enemyFirstMove(shipE5);
                fr.remove(buttonStart);
                fr.add(buttonStop);
                isStarted=true;
                playingGame();
            }
            });
             buttonPause.addActionListener(new ActionListener() {

                 //the button "pause" is pressed, the game paused until the players press the "resume" button.
            @Override
            public void actionPerformed(ActionEvent e) {
            System.out.println("Button pause is pressed");
            fr.remove(buttonPause);
            fr.add(buttonResume);
            isPaused=true;
            }
            });
             buttonFire.addActionListener(new ActionListener() {
                 //the button "fire" is pressed, it calls the fireBoardXY so the player can attack the enemy using the coordinate.
            @Override
            public void actionPerformed(ActionEvent e) {
            System.out.println("button fire is pressed");
            fireBoardXY();
            fr.remove(buttonFire);

            }
            });
             buttonStop.addActionListener(new ActionListener() {
                 //the "stop" button is pressed, it starts the game from the beginning.
            @Override
            public void actionPerformed(ActionEvent e) {
            fr.remove(buttonStop);
            PlayerShip.removeShip(fr,ship1);
            PlayerShip.removeShip(fr,ship2);
            PlayerShip.removeShip(fr,ship3);
            PlayerShip.removeShip(fr,ship4);
            PlayerShip.removeShip(fr,ship5);
            PlayerShip.removeShip(fr, shipE1);
            PlayerShip.removeShip(fr,shipE2);
            PlayerShip.removeShip(fr,shipE3);
            PlayerShip.removeShip(fr,shipE4);
            PlayerShip.removeShip(fr,shipE5);
            putShip();
            putEnemyShip();
            fr.add(buttonStart);
            }
            });
             buttonResume.addActionListener(new ActionListener() {
                 // It removes the "Resume" button from the frame and adds the "Pause" button instead.
            @Override
            public void actionPerformed(ActionEvent e) {
            fr.remove(buttonResume);
            fr.add(buttonPause);
            }
            });


             // This method is triggered when the "FIRE" button is clicked.
            // It creates GUI components for entering the X and Y coordinates to fire at the enemy ship.
        }
        public void fireBoardXY() {
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

            fireXTF.setLocation(80, 540);
            fireYTF.setLocation(80, 570);


            fireXTF.setSize(45, 25);
            fireYTF.setSize(45, 25);

            buttonConfirm = new JButton("Confirm");
            buttonConfirm.setSize(100, 20);
            buttonConfirm.setLocation(250, 550);
            fr.add(buttonConfirm);
            fr.add(fireXTF);
            fr.add(fireYTF);
            fr.add(fireX);
            fr.add(fireY);

            // After the "Confirm" button is pressed, it retrieves the entered coordinates, removes the GUI components,
            //  and calls playerFire() and enemyFire() methods to check for hits and update the game state accordingly.

            buttonConfirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    playerFire();
                    fr.remove(fireX);
                    fr.remove(fireY);
                    fr.remove(fireXTF);
                    fr.remove(fireYTF);
                    fr.remove(buttonConfirm);
                    Score.situation(fr,playing, "Computer Turn");
                    enemyFire();
                    enemyFire();
                    enemyFire();
                    enemyFire();
                    enemyFire();
                    enemyFire();
                    enemyFire();
                    enemyFire();
                    enemyFire();
                    enemyFire();
                    fr.add(buttonFire);
                    Score.situation(fr,playing,"Player Turn");

                }
            });
        }

        // adds labels for coordinate markers on the frame.
    // calls the putLabelSerial() method of the LabelCoordinate class to place labels on the game board.
        public void putLabel(){
    LabelCoordinate lc=new LabelCoordinate();
    lc.putLabelSerial();
        }

        // methods for handling the fire action button
    // It retrieves the X and Y coordinates entered by the player from the fireXTF and fireYTF text fields.
        public void playerFire(){
        int xE=Integer.valueOf(fireXTF.getText());
        int yE=Integer.valueOf(fireYTF.getText());
        boolean isSunk=PlayerShip.isEnemyHit(shipE1,xE,yE);

        // It checks if the player's shots hit any enemy ships using the isEnemyHit() method of the PlayerShip class.

            if (isSunk){
                fr.remove(shipE1);
                enemyNumber=enemyNumber-1;
            }
            isSunk=PlayerShip.isEnemyHit(shipE2,xE,yE);
            if (isSunk){
                fr.remove(shipE2);
                enemyNumber=enemyNumber-1;
            }
            isSunk=PlayerShip.isEnemyHit(shipE3,xE,yE);
            if (isSunk){
                fr.remove(shipE3);
                enemyNumber=enemyNumber-1;
            }
            isSunk=PlayerShip.isEnemyHit(shipE4,xE,yE);
            if (isSunk){
                fr.remove(shipE4);
                enemyNumber=enemyNumber-1;
            }
            isSunk=PlayerShip.isEnemyHit(shipE5,xE,yE);
            if (isSunk){
                fr.remove(shipE5);
                enemyNumber=enemyNumber-1;
            }
            if(enemyNumber<1){
                Score.situation(fr, playing,"Player won, game over");
                gameOver();
            }

        }
        // methods for handling fire action
        public void enemyFire(){
            int xP = random.nextInt(9);
            int yP = random.nextInt(9);
            boolean isPlayerSunk= EnemyShip.isPlayerHit(ship1,xP,yP);

            // It checks if the enemy's shots hit any player ships using the isPlayerHit() method of the EnemyShip class.

            if (isPlayerSunk){
                fr.remove(ship1);
                playerNumber=playerNumber-1;
            }
            isPlayerSunk=EnemyShip.isPlayerHit(ship2,xP,yP);
            if (isPlayerSunk){
                fr.remove(ship2);
                playerNumber=playerNumber-1;
            }
            isPlayerSunk=EnemyShip.isPlayerHit(ship3,xP,yP);
            if (isPlayerSunk){
                fr.remove(ship3);
                playerNumber=playerNumber-1;
            }
            isPlayerSunk=EnemyShip.isPlayerHit(ship4,xP,yP);
            if (isPlayerSunk){
                fr.remove(ship4);
                playerNumber=playerNumber-1;
            }
            isPlayerSunk=EnemyShip.isPlayerHit(ship5,xP,yP);
            if (isPlayerSunk){
                fr.remove(ship5);
                playerNumber=playerNumber-1;
            }
            if(playerNumber<1){
                Score.situation(fr,playing, "Computer Won, Game Over");
                gameOver();

            }
        }

        // This method handles the motion of enemy ships.
        public void enemyMotion(){
        EnemyShip es=new EnemyShip();
            for (int i=0; i<600;i++){

                // It repeatedly calls the moveEnemy() method of the EnemyShip class to move each enemy ship.
                    es.moveEnemy(shipE1);
                    es.moveEnemy(shipE2);
                    es.moveEnemy(shipE3);
                    es.moveEnemy(shipE4);
                    es.moveEnemy(shipE5);

                    // After each ship is moved, there is a delay of 6000 milliseconds (6 seconds) before moving the next ship.
                    try {
                        TimeUnit.MILLISECONDS.sleep(6000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
       // When start button is pressed
        public void playingGame(){
        fr.add(buttonPause);
        fr.add(buttonFire);
        Score.situation(fr,playing,"Player Turn");

}
// This method is responsible for handling the game over. It displays the message "GAMEOVER"
public void gameOver(){
    JOptionPane.showMessageDialog(fr,"GAMEOVER");
        System.out.println("Game Over!");
        fr.remove(buttonStop);
        PlayerShip.removeShip(fr,ship1);
        PlayerShip.removeShip(fr,ship2);
        PlayerShip.removeShip(fr,ship3);
        PlayerShip.removeShip(fr,ship4);
        PlayerShip.removeShip(fr,ship5);
        PlayerShip.removeShip(fr, shipE1);
        PlayerShip.removeShip(fr,shipE2);
        PlayerShip.removeShip(fr,shipE3);
        PlayerShip.removeShip(fr,shipE4);
        PlayerShip.removeShip(fr,shipE5);
        putEnemyShip();
        putShip();
        fr.add(buttonStart);

        }
    }



