package CHAPTER_15.Question15_11;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eliahmbwilo on 12/1/17.
 */

/**
 * ------------------------ Problem definition --------------------------
 * (Grid Using Method drawLine) Write an application that draws an 8-by-8 grid. Use Graphics method drawLine.
 * I'll start with a 4 by 4 grid
 */

public class DrawGridPanel extends JPanel {
    private int incrementX;
    private int incrementY;
    private int startX;
    private int startY;

    public DrawGridPanel() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        incrementX = getWidth() / 8;
        incrementY = getHeight() / 8;
        startX = incrementX;
        startY = incrementY;

        // drawing the rows
        for (int i = 1; i < 8; i++) {
            g.drawLine(0, startY, getWidth(), startY);      // y should be constant and x should increment by some fixed amount that will generate the required number of rows
            // increment the distance required
            startY += incrementY;
        }
        // drawing the columns
        for (int i = 1; i < 8; i++) {
            g.drawLine(startX, 0, startX, getHeight());     // x should be constant and y should increment by some fixed amount that will generate the required number of columns
            // incrementing the distance is required
            startX += incrementX;
        }
    }
}
