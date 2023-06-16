import javax.swing.*;
import java.awt.*;

public class Boundary {
    JPanel  boundary;
    JPanel boundary1;
    JPanel boundary2;
    JPanel boundary3;
    JPanel boundary4;
    public void putBoundary(JFrame x){
        boundary = new JPanel();
        boundary.setSize(10, 400);
        boundary.setBackground(Color.red);
        boundary.setLocation(500, 100);
        x.add(boundary);
    }
    public void putBoundary1(JFrame x){
        boundary1 = new JPanel();
        boundary1.setSize(10, 400);
        boundary1.setBackground(Color.ORANGE);
        boundary1.setLocation(90, 100);
        x.add(boundary1);

    }
    public void putBoundary2(JFrame x){
        boundary2 = new JPanel();
        boundary2.setSize(10, 400);
        boundary2.setBackground(Color.ORANGE);
        boundary2.setLocation(910, 100);
        x.add(boundary2);
    }
public void putBoundary3(JFrame x){
    boundary3 = new JPanel();
    boundary3.setSize(830, 10);
    boundary3.setBackground(Color.ORANGE);
    boundary3.setLocation(90, 90);
    x.add(boundary3);
}
public void putBoundary4(JFrame x){
    boundary4 = new JPanel();
    boundary4.setSize(830, 10);
    boundary4.setBackground(Color.ORANGE);
    boundary4.setLocation(90, 500);
    x.add(boundary4);

}
}
