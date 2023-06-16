import javax.swing.*;
import java.awt.*;

public class Score {
    JPanel scorePlayer, scoreEnemy;
    public void putScore(JFrame fr) {
        scorePlayer = new JPanel();
        scoreEnemy = new JPanel();
        scorePlayer.setSize(100, 30);
        scorePlayer.setLocation(200, 50);
        scorePlayer.setBackground(Color.ORANGE);
        scoreEnemy.setBackground(Color.ORANGE);
        scoreEnemy.setLocation(700, 50);
        scoreEnemy.setSize(100, 30);
        JLabel player = new JLabel("Player\n");
        JLabel enemy = new JLabel("Enemy\n");
        //JLabel enemyScore = new JLabel("10");
        //JLabel playerScore = new JLabel("20");
        scorePlayer.add(player);
        //scorePlayer.add(playerScore);
        scoreEnemy.add(enemy);
       // scoreEnemy.add(enemyScore);

        fr.add(scorePlayer);
        fr.add(scoreEnemy);


    }
    public static void situation(JFrame fr,JLabel lb, String s){
        lb.setSize(300,30);
        lb.setLocation(350, 50);
        lb.setBackground(Color.pink);
        lb.setText(s);
        fr.add(lb);

    }
}
