package CHAPTER_15.Question15_6;

/**
 * Created by eliahmbwilo on 11/27/17.
 */

import javax.swing.*;
import java.awt.*;

/**
 * ---------------- Problem definition ---------------
 * Write an application that draws a series of eight
   concentric circles. The circles should be separated by 10 pixels. Use Graphics method drawArc.

 */
public class ConcentricCirclesFrame {
    public static final int X_TOP = 300;
    public static final int Y_TOP = 200;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                ConcentricCirclesJPanel concentricCirclesJPanel = new ConcentricCirclesJPanel();
                frame.add(concentricCirclesJPanel);
                frame.setTitle("Concentric Circles");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(X_TOP, Y_TOP, WIDTH, HEIGHT);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
    }


}
