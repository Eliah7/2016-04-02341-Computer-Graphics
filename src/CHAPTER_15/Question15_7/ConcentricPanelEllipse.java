package CHAPTER_15.Question15_7;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by eliahmbwilo on 11/27/17.
 */
public class ConcentricPanelEllipse extends JPanel{
    // declaration of variables
    double distance;
    double parentWidth;
    double parentHeight;
    double circleWidth;
    double circleHeight;

    public ConcentricPanelEllipse(){
        distance = 10;  // this is the separation distance between circles
        parentHeight = ConcentricFrame.HEIGHT/3;
        parentWidth = ConcentricFrame.WIDTH/3 + 50;
        circleWidth = 50;
        circleHeight = 50;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0;i<10;i++) {
            Ellipse2D.Double ellipse = new Ellipse2D.Double(parentWidth,parentHeight,circleWidth,circleHeight);
            g2.draw(ellipse);
           circleWidth = circleWidth + 2*(Math.sqrt((double) 50));  // use the pythagorous theorem to adjust the location of x1 and y1
            circleHeight  = circleHeight + 2*(Math.sqrt((double) 50));
           parentWidth -= Math.sqrt((double) 50);
            parentHeight -= Math.sqrt((double) 50);


        }
    }
}
