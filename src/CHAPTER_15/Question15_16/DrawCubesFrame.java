package CHAPTER_15.Question15_16;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eliahmbwilo on 12/2/17.
 */
public class DrawCubesFrame {
    public static final int X_TOP = 300;
    public static final int Y_TOP = 200;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                DrawCubesPanel drawCubesPanel = new DrawCubesPanel();
                frame.add(drawCubesPanel);
                frame.setTitle("Drawing Cubes");

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(X_TOP, Y_TOP, WIDTH, HEIGHT);
                frame.setResizable(true);
                frame.setVisible(true);
            }
        });
    }
}
