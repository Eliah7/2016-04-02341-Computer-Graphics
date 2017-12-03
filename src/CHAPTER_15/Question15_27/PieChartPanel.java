package CHAPTER_15.Question15_27;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.Random;

/**
 * Created by eliahmbwilo on 12/3/17.
 */

/**
 * --------------------------- Problem definition --------------------------------
 * (Pie Chart) Write a program that inputs four numbers and graphs them as a pie chart.
 * Use class Arc2D.Double and method fill of class Graphics2D to perform the drawing.
 * Draw each piece of the pie in a separate color.
 */
public class PieChartPanel extends JPanel {
    private int numbersEntered[];
    public double xTop;
    public double yTop;
    private double width;
    double drawAngle = 0;

    public PieChartPanel() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        xTop = (this.getWidth() / 2) - 50;
        yTop = (this.getHeight() / 2) - 50;
        width = 150;

        Graphics2D g2 = (Graphics2D) g; // casting the graphics object to a graphics2D object
        double arcAngle = 0;
        int total = 0;
        double start[] = new double[4];
        if (numbersEntered != null) {

            for (int i = 0; i < numbersEntered.length; i++) {  // a for-loop to get the total of the numbers entered
                total += numbersEntered[0];
            }

            for (int number : numbersEntered) {   // to draw the arcs representing the pie chart
                arcAngle = 360 * (number) / total;
                //drawAngle += arcAngle;

                if (number == numbersEntered[0]) {
                    g2.setColor(new Color(generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat()));
                    g2.fill(new Arc2D.Double(xTop, yTop, width, width, 0, arcAngle, Arc2D.PIE));
                    start[0] = arcAngle;

                } else if (number == numbersEntered[1]) {
                    g2.setColor(new Color(generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat()));
                    g2.fill(new Arc2D.Double(xTop, yTop, width, width, start[0], arcAngle, Arc2D.PIE));
                    start[1] = start[0] + arcAngle;
                } else if (number == numbersEntered[2]) {
                    g2.setColor(new Color(generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat()));
                    g2.fill(new Arc2D.Double(xTop, yTop, width, width, start[1], arcAngle, Arc2D.PIE));
                    start[2] = start[1] + arcAngle;
                } else if (number == numbersEntered[3]) {
                    g2.setColor(new Color(generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat()));

                    g2.fill(new Arc2D.Double(xTop, yTop, width, width, start[2], arcAngle, Arc2D.PIE));
                    start[3] = start[2] + arcAngle;

                } else {
                    g2.setColor(new Color(generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat()));

                    g2.fill(new Arc2D.Double(xTop, yTop, width, width, start[3], arcAngle, Arc2D.PIE));
                }
                System.out.println(arcAngle);
            }
        }
    }

    public void receiveArray(int numbersEntered[]) {  // received the array entered
        this.numbersEntered = numbersEntered;
    }

    public float generateRandomColorFloat() { // generate a random number from 0.0 to 1.0
        Random rand = new Random();
        float n = rand.nextFloat();
        return n;
    }
}
