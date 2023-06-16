import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
public GameGUI(){
    initGUI();
    //enemyMotion();
   // gameOver();

}
    public void initGUI() {
        //Frame
        //fr=new JFrame("Battleship");

        fr.setLayout(null);
        fr.setBackground(Color.BLUE);

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
        //putBtn();
        //buttonAction();
        putButton();
        putLabel();
        //PlayerShip ps=new PlayerShip();
      //  ps.posShip();
       // EnemyShip es=new EnemyShip();
       // es.posEnemy();
        //fire();
       // enemyMotion();
       // enemyMotion();


       // gameOver();
        enemyMotion();
        gameOver();





    }
    public void putBnd(){
        Boundary b=new Boundary();
        b.putBoundary(fr);
        b.putBoundary1(fr);
        b.putBoundary2(fr);
        b.putBoundary3(fr);
        b.putBoundary4(fr);
    }
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
    public void putEnemyShip(){
    shipE1=new JLabel(new ImageIcon("src/images/kapal.jpg"));
    EnemyShip.putEnemyShip(fr,shipE1,860,200);
        shipE2=new JLabel(new ImageIcon("src/images/kapal.jpg"));
        EnemyShip.putEnemyShip(fr,shipE2,860,250);
        shipE3=new JLabel(new ImageIcon("src/images/kapal.jpg"));
        EnemyShip.putEnemyShip(fr,shipE3,860,300);
        shipE4=new JLabel(new ImageIcon("src/images/kapal.jpg"));
        EnemyShip.putEnemyShip(fr,shipE4,860,350);
        shipE5=new JLabel(new ImageIcon("src/images/kapal.jpg"));
        EnemyShip.putEnemyShip(fr,shipE5,860,400);



    }

    public void putScoreLabel(){
    Score score=new Score();
    score.putScore(fr);

    }

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
            //fr.add(buttonFire);
            //fr.add(buttonPause);

             buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //System.out.println("Button Start is Pressed");isStarted=true;
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


            //enemyMove();
            // playerFirstMove();
                fr.remove(buttonStart);
                fr.add(buttonStop);
                isStarted=true;
                playingGame();

                //enemyMotion();
               // enemyMotion();

            //enemyMotion();
               // enemyFire();
            }
            });
             buttonPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.out.println("Button pause is pressed");
            fr.remove(buttonPause);
            fr.add(buttonResume);
            isPaused=true;
            }
            });
             buttonFire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.out.println("button fire is pressed");
            fireBoardXY();
            fr.remove(buttonFire);

            }
            });
             buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            // putPlayerShip();
            //putEnemyShip();
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
            @Override
            public void actionPerformed(ActionEvent e) {

            fr.remove(buttonResume);
            fr.add(buttonPause);
            }
            });







        }
        public void fireBoardXY() {
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
                    //JComboBox cb = (JComboBox)e.getSource();
                   // String shipData = (String)cb.getSelectedItem();
                    //fireEnemy();
                    //enemyMotion();
                    playerFire();
                    fr.remove(fireX);
                    fr.remove(fireY);
                    fr.remove(fireXTF);
                    fr.remove(fireYTF);
                    fr.remove(buttonConfirm);
                    Score.situation(fr,playing, "Computer Turn");
                    enemyFire();
                   // enemyMotion();
                    fr.add(buttonFire);
                    //enemyMotion();
                    //enemyMotion();
                    Score.situation(fr,playing,"Player Turn");


                    System.out.println(" Ship to fire is ship "+ shipData);
                }
            });


        }
        public void putLabel(){
    LabelCoordinate lc=new LabelCoordinate();
    lc.putLabelSerial();
        }
        public void playerFire(){
        int xE=Integer.valueOf(fireXTF.getText());
        int yE=Integer.valueOf(fireYTF.getText());
        boolean isSunk=PlayerShip.isEnemyHit(shipE1,xE,yE);
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
        public void enemyFire(){
            int xP = random.nextInt(9);
            int yP = random.nextInt(9);
            boolean isPlayerSunk= EnemyShip.isPlayerHit(ship1,xP,yP);
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
        public void enemyMotion(){
    EnemyShip es=new EnemyShip();
            for (int i=0; i<600;i++){

                    es.moveEnemy(shipE1);
                    es.moveEnemy(shipE2);
                    es.moveEnemy(shipE3);
                    es.moveEnemy(shipE4);
                    es.moveEnemy(shipE5);
                    try {
                        TimeUnit.MILLISECONDS.sleep(6000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }

            }




       //When start button is pressed
        public void playingGame(){
        fr.add(buttonPause);
        fr.add(buttonFire);
        Score.situation(fr,playing,"Player Turn");
       // enemyMotion();
        //enemyMotion();
        //enemyMotion();
}
public void gameOver(){

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
        fr.add(buttonStart);


}

    }



