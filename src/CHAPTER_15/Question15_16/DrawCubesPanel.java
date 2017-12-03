package CHAPTER_15.Question15_16;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

/**
 * Created by eliahmbwilo on 12/2/17.
 */

/**
 * ----------------------------- Problem definition ------------------------------
 *  (Drawing Cubes) Write an application that draws a cube. Use class GeneralPath and method draw of class Graphics2D.

 */

public class DrawCubesPanel extends JPanel {
    public DrawCubesPanel(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;   // casting the graphics object to a graphics2D object

        int xPoints[] = {100,200,100,200,250,250,150};
        int yPoints[] = {100,100,200,200,80,180,80};

        GeneralPath cube = new GeneralPath();

        cube.moveTo(xPoints[0],yPoints[0]);
        cube.lineTo(xPoints[1],yPoints[1]);
        cube.moveTo(xPoints[0],yPoints[0]);
        cube.lineTo(xPoints[2],yPoints[2]);
        cube.lineTo(xPoints[3],yPoints[3]);
        cube.lineTo(xPoints[1],yPoints[1]);
        cube.lineTo(xPoints[4],yPoints[4]);
        cube.lineTo(xPoints[5],yPoints[5]);
        cube.lineTo(xPoints[3],yPoints[3]);
        cube.moveTo(xPoints[4],yPoints[4]);
        cube.lineTo(xPoints[6],yPoints[6]);
        cube.lineTo(xPoints[0],yPoints[0]);
        //cube.closePath();


        g2.draw(cube);




    }
}
