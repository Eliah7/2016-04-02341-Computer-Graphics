package CHAPTER_15.Question15_8;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

/**
 * Created by eliahmbwilo on 11/28/17.
 */
public class RandomLinesPanel extends JPanel {
    public int xTop;
    public int yTop;
    public int width;
    public int height;

    public RandomLinesPanel() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        Line2D line2D[] = new Line2D.Double[20];
        // Line2D line = new Line2D.Double(xTop,yTop,width,height);

        for (int i = 0; i <line2D.length - 1;i++) {
            // setting the new color and stroke size for the lines
            g2.setStroke(new BasicStroke(generateRandomIntStroke()));
            g2.setColor(new Color(generateRandomColorFloat(),generateRandomColorFloat(),generateRandomColorFloat(),generateRandomColorFloat()));

            //instantiating the variables a new
            xTop = generateRandomInt();
            yTop = generateRandomInt();
            width = generateRandomInt();
            height = generateRandomInt();

            // creating and drawing each line in the array
            line2D[i] = new Line2D.Double(xTop, yTop, width, height);
            g2.draw(line2D[i]);

        }
        // don't use a different for loop all the instantiated variables then have the same values stored

    }

    private int generateRandomIntStroke() {
        Random rand = new Random();
        int n = rand.nextInt(30) + 1;
        return n;
    }

    public int generateRandomInt() {  // generate a random number from 1 to 1000
        Random rand = new Random();
        int n = rand.nextInt(500) + 1;
        return n;
    }

    public float generateRandomColorFloat(){ // generate a random number from 0.0 to 1.0
        Random rand = new Random();
        float n = rand.nextFloat();
        return n;
    }
}
