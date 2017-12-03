package CHAPTER_15.Question15_26;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eliahmbwilo on 12/3/17.
 */

/**
 * ---------------------- Problem definition -----------------------
 * (Drawing Spirals)
 * Write an application that uses Graphics method drawPolyline to draw a spiral similar to the one shown in Fig. 15.33.
 */

public class DrawSpiralsPanel extends JPanel {
    public int startX = 120;
    public int startY = 100;

    public DrawSpiralsPanel() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int xPoints[] = new int[8];
        int yPoints[] = {100, 120, 120, 100, 90, 80, 90, 100};

        xPoints[0] = startX;
        yPoints[0] = startY;
        int countX = 0;
        int countY = 0;

        boolean opposite = false;  // boolean to check if four intervals have been reached
        int interval = 20;  // interval to increase the x and y values

        for (int i = 0; i < 8; i++) {
            // create the values of the xPoints
            // xPoints[i] = 200;
            if (countX == 4) {
                countX = 0;
                opposite = !opposite;
                interval = -60;
            }


            if (opposite) {
                xPoints[i] = startX + interval;
                interval += 20;

            } else {
                xPoints[i] = startX - interval;
                interval += 20;

            }

            countX++;
        }


        g.drawPolyline(xPoints, yPoints, yPoints.length);
    }
}
