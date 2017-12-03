package CHAPTER_15.Question15_21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by eliahmbwilo on 12/3/17.
 */

/**
 * -------------------- Problem definition --------------------------
 * (Screen Saver with Shapes)
 * Modify your solution to Exercise 15.19 such that it uses ran- dom-number generation to choose different shapes to display.
 * Use methods of class Graphics.
 */


public class ScreenSaverShapesPanel extends JPanel implements ActionListener {
    public int xTop;
    public int yTop;
    public int width;
    public int height;

    private Timer timer;

    public ScreenSaverShapesPanel() {
        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int count = 0; count < 100; count++) {

            if (count == 100) {  // check if 100 shapes have been drawn and then clear then screen

                g.clearRect(0, 0, getWidth(), getHeight());

            } else {
                //instantiating the variables a new each iteration
                xTop = generateRandomIntX();
                yTop = generateRandomIntY();
                width = generateRandomIntX();
                height = generateRandomIntY();

                g.setColor(new Color(generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat()));

                // creating and drawing a random shape
                switch (generateRandomShape()) {
                    case 1:
                        g.drawLine(xTop, yTop, width, height);
                        break;
                    case 2:
                        g.fill3DRect(xTop, yTop, width, height, true);

                        break;

                    case 3:
                        g.fillOval(xTop, yTop, width, height);
                        break;

                    case 4:

                        g.drawRoundRect(xTop, yTop, width, height,10,10);
                        break;

                    default:
                        g.drawLine(xTop, yTop, width, height);
                        break;
                }
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
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

    public int generateRandomShape() {
        Random rand = new Random();
        int n = rand.nextInt(4) + 1;
        return n;
    }

    public float generateRandomColorFloat() { // generate a random number from 0.0 to 1.0
        Random rand = new Random();
        float n = rand.nextFloat();
        return n;
    }
}
