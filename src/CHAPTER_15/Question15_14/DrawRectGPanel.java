package CHAPTER_15.Question15_14;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eliahmbwilo on 12/2/17.
 */
public class DrawRectGPanel extends JPanel {
    private double incrementX;
    private double incrementY;
    private double startX;
    private double startY;
    private double xIndex;
    private double yIndex;

    public DrawRectGPanel() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g; // casting the graphics object to a Graphics2D object

        incrementX = getWidth() / 8;
        incrementY = getHeight() / 8;
        startX = incrementX;
        startY = incrementY;
        xIndex = 0;
        yIndex = 0;

        // drawing the rows
        for (int i = 0; i < 8; i++) {
            g2.draw(new Rectangle.Double(0, yIndex, getWidth(), startY));
            yIndex += incrementY;

        }

        // drawing the columns
        for (int i = 0; i < 8; i++) {
            g2.draw(new Rectangle.Double(xIndex, 0, startX, getHeight()));
            xIndex += incrementX;
        }
    }
}
