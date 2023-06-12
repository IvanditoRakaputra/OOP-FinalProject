import javax.swing.*;
import java.awt.*;
//import java.util.HashMap;
//import java.util.Map;

// For managing and displaying the scores of the player and the enemy in the game.
public class Score {
    // JPanel representing the player's score and the enemy's score.
    JPanel scorePlayer, scoreEnemy;

    // This method is used to create the score panels and add them to the game frame.
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

        scorePlayer.add(player);

        scoreEnemy.add(enemy);

        fr.add(scorePlayer);
        fr.add(scoreEnemy);

    }

    // This method is used to update the situation label, which provides information about the game status or current situation.
    public static void situation(JFrame fr,JLabel lb, String s){
        lb.setSize(300,30);
        lb.setLocation(350, 50);
        lb.setBackground(Color.ORANGE);
        lb.setText(s);
        fr.add(lb);

        //    private JPanel scorePanel;
//    private Map<String, JLabel> scoreLabels;
//
//    public Score() {
//        scorePanel = new JPanel();
//        scorePanel.setLayout(new GridLayout(0, 2));
//        scoreLabels = new HashMap<>();
//    }
//
//    public void putScore(JFrame frame, String player, String enemy) {
//        JLabel playerLabel = new JLabel("Player: " + player);
//        JLabel enemyLabel = new JLabel("Enemy: " + enemy);
//
//        scoreLabels.put("Player", playerLabel);
//        scoreLabels.put("Enemy", enemyLabel);
//
//        scorePanel.add(playerLabel);
//        scorePanel.add(enemyLabel);
//
//        frame.add(scorePanel);
//    }
//
//    public void updateScore(String player, int score) {
//        JLabel label = scoreLabels.get(player);
//        if (label != null) {
//            label.setText(player + ": " + score);
//        }
//    }
//}

    }
}
