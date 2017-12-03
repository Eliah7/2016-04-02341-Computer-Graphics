package CHAPTER_15.Question15_18;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by eliahmbwilo on 12/2/17.
 */

/**
 * ----------------------- Problem definition ------------------------
 * (Screen Saver) Write an application that simulates a screen saver.
 * The application should randomly draw lines using method drawLine of class Graphics.
 * After drawing 100 lines, the application should clear itself and start drawing lines again.
 * To allow the program to draw continuously, place a call to repaint as the last line in method paintComponent.
 * Do you notice any problems with this on your system?
 */

public class ScreenSaverPanel extends JPanel {
    public int xTop;
    public int yTop;
    public int width;
    public int height;

    public ScreenSaverPanel() {

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        // Line2D line = new Line2D.Double(xTop,yTop,width,height);

        for (int count = 0; count < 100; count++) {
            // setting the new color and stroke size for the lines


            if (count == 100) {  // check if 100 lines have been drawn and th
                g.clearRect(0, 0, getWidth(), getHeight());
            } else {
                //instantiating the variables a new
                xTop = generateRandomIntX();
                yTop = generateRandomIntY();
                width = generateRandomIntX();
                height = generateRandomIntY();


                // creating and drawing each line in the array
                g.drawLine(xTop, yTop, width, height);
            }

        }

        repaint();
        // don't use a different for loop all the instantiated variables then have the same values stored

    }

    private int generateRandomIntX() {
        Random rand = new Random();
        int n = rand.nextInt(getWidth()) + 1;
        return n;
    }

    public int generateRandomIntY() {  // generate a random number from 1 to 1000
        Random rand = new Random();
        int n = rand.nextInt(getHeight()) + 1;
        return n;
    }

    public float generateRandomColorFloat() { // generate a random number from 0.0 to 1.0
        Random rand = new Random();
        float n = rand.nextFloat();
        return n;
    }
}
