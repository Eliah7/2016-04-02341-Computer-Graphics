package CHAPTER_15.Question15_13;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eliahmbwilo on 12/1/17.
 */

/**
 * --------------------------- Problem definition -------------------------------
 * (Grid Using Method drawRect) Write an application that draws a 10-by-10 grid. Use the Graphics method drawRect.
 */

public class DrawRectGridPanel extends JPanel {
    private int incrementX;
    private int incrementY;
    private int startX;
    private int startY;
    private int xIndex;
    private int yIndex;

    public DrawRectGridPanel() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        incrementX = getWidth() / 8;
        incrementY = getHeight() / 8;
        startX = incrementX;
        startY = incrementY;
        xIndex = 0;
        yIndex = 0;

        // drawing the rows
        for (int i = 0; i < 8; i++) {
            g.drawRect(0, yIndex, getWidth(), startY);
            yIndex += incrementY;

        }

        // drawing the columns
        for (int i = 0; i < 8; i++) {
            g.drawRect(xIndex, 0, startX, getHeight());
            xIndex += incrementX;
        }
    }
}
