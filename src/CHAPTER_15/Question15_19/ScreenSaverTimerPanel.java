package CHAPTER_15.Question15_19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by eliahmbwilo on 12/2/17.
 */
public class ScreenSaverTimerPanel extends JPanel implements ActionListener {
    public int xTop;
    public int yTop;
    public int width;
    public int height;

    private Timer timer;

    public ScreenSaverTimerPanel() {
        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

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

    public float generateRandomColorFloat() { // generate a random number from 0.0 to 1.0
        Random rand = new Random();
        float n = rand.nextFloat();
        return n;
    }
}
