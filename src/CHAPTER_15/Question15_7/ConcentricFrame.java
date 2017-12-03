package CHAPTER_15.Question15_7;



import javax.swing.*;
import java.awt.*;

/**
 * Created by eliahmbwilo on 11/27/17.
 */
public class ConcentricFrame {
    public static final int X_TOP = 300;
    public static final int Y_TOP = 200;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                JPanel panel = new ConcentricPanelEllipse();
                frame.add(panel);
                frame.setTitle("Concentric Circles");

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(X_TOP, Y_TOP, WIDTH, HEIGHT);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
    }
}
