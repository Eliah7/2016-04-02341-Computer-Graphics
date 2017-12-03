package CHAPTER_15.Question15_9;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Random;

/**
 * Created by eliahmbwilo on 11/28/17.
 */
public class RandomTrianglesPanel extends JPanel {

    public RandomTrianglesPanel() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


        GeneralPath[] triangle = new GeneralPath[20]; // create a new general path object
        for (int i = 0; i < triangle.length; i++) {
            int[] xPoints = {0, generateRandomInt(), generateRandomInt()};
            int[] yPoints = {0, generateRandomInt(), generateRandomInt()};
            triangle[i] = new GeneralPath();

            triangle[i].moveTo(generateRandomInt(), generateRandomInt());

            for (int count = 1; count < xPoints.length; count++)
                triangle[i].lineTo(xPoints[count], yPoints[count]);

            triangle[i].closePath();
            g2.setColor(new Color(generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat()));
            g2.fill(triangle[i]);
        }
    }

    public float generateRandomColorFloat() { // generate a random number from 0.0 to 1.0
        Random rand = new Random();
        float n = rand.nextFloat();
        return n;
    }

    public int generateRandomInt() {  // generate a random number from 1 to 1000
        Random rand = new Random();
        int n = rand.nextInt(400) + 1;
        return n;
    }
}
