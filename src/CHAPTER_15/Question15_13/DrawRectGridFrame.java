package CHAPTER_15.Question15_13;


import javax.swing.*;
import java.awt.*;

/**
 * Created by eliahmbwilo on 12/1/17.
 */
public class DrawRectGridFrame {
    public static final int X_TOP = 300;
    public static final int Y_TOP = 200;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                DrawRectGridPanel rectGridPanel = new DrawRectGridPanel();
                frame.add(rectGridPanel);
                frame.setTitle("8 by 8 - Grid");

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(X_TOP, Y_TOP, WIDTH, HEIGHT);
                frame.setResizable(true);
                frame.setVisible(true);
            }
        });
    }
}
