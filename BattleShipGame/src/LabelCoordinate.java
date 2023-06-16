import javax.swing.*;
import java.awt.*;

public class LabelCoordinate {
    public static void PutNumberLabel(JFrame x, int i){

        JLabel name=new JLabel();
        name.setSize(20,30);
        name.setBackground(Color.ORANGE);
        String text=String.valueOf(i);
        name.setText(text);
        name.setLocation(50+i*50,510);
        x.add(name);
        JLabel nameY=new JLabel();
        nameY.setSize(20,30);
        nameY.setBackground(Color.ORANGE);
        nameY.setText(String.valueOf(i));
        nameY.setLocation(70,500-i*50);
        x.add(nameY);

        JLabel enemy=new JLabel();
        enemy.setSize(20,30);
        enemy.setBackground(Color.ORANGE);
        enemy.setText(String.valueOf(i));
        enemy.setLocation(910-i*50, 510);
        x.add(enemy);


        JLabel enemyY=new JLabel();
        enemyY.setSize(20,30);
        enemyY.setBackground(Color.ORANGE);
        enemyY.setText(String.valueOf(i));
        enemyY.setLocation(920, 500-i*50);
        x.add(enemyY);



    }
    public static void putLabelSerial(){
        for (int j=1;j<9;j++){
            PutNumberLabel(GameGUI.fr, j);
        }
    }
}
