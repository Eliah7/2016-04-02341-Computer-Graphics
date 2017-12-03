package CHAPTER_15.Question15_6;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eliahmbwilo on 11/27/17.
 */
public class ConcentricCirclesJPanel extends JPanel {
    // declaration of variables
    int distance;
    int parentWidth;
    int parentHeight;
    int circleWidth;
    int circleHeight;

    public ConcentricCirclesJPanel(){
        distance = 10;  // this is the separation distance between circles
        parentHeight = ConcentricCirclesFrame.HEIGHT/3;
        parentWidth = ConcentricCirclesFrame.WIDTH/3 + 50;
        circleWidth = 50;
        circleHeight = 50;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0;i<10;i++) {
            g.drawArc(parentWidth,parentHeight,circleWidth,circleHeight,0,360);

            circleWidth = circleWidth + 2*((int)Math.sqrt((double) 50));  // use the pythagorous theorem to adjust the location of x1 and y1
           circleHeight  = circleHeight + 2*((int)Math.sqrt((double) 50));
            parentWidth -= Math.sqrt((double) 50);
            parentHeight -= Math.sqrt((double) 50);

            // its not perfect but I can live with it !!!!!
        }
    }
}
