package CHAPTER_15.Question15_12;

/**
 * Created by eliahmbwilo on 12/1/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * ----------------------------------- Problem definition ----------------------------------------
 * (Grid Using Class Line2D.Double)
 * Modify your solution to Exercise 15.11 to draw the grid using instances of class Line2D.Double and method draw of class Graphics2D.
 */

public class DrawGridLinePanel extends JPanel {
    public int incrementX;
    public int incrementY;
    public int startX;
    public int startY;

    public DrawGridLinePanel() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;   // casting the graphics object to a graphics 2d object

        incrementX = getWidth() / 8;
        incrementY = getHeight() / 8;
        startX = incrementX;
        startY = incrementY;

        // drawing the rows
        for (int i = 1; i < 8; i++) {
            g2.draw(new Line2D.Double(0, startY, getWidth(), startY));      // y should be constant and x should increment by some fixed amount that will generate the required number of rows
            // increment the distance required
            startY += incrementY;
        }
        // drawing the columns
        for (int i = 1; i < 8; i++) {
            g2.draw(new Line2D.Double(startX, 0, startX, getHeight()));     // x should be constant and y should increment by some fixed amount that will generate the required number of columns
            // incrementing the distance is required
            startX += incrementX;
        }
    }
}
