package CHAPTER_14.Question14_17;

import java.awt.*;

/**
 * Created by eliahmbwilo on 11/19/17.
 */
public class MyLine extends MyShape {
    private Color shapeColor;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public MyLine() {  // a no argument constructor
        shapeColor = Color.black;
        x1 = 0;
        x2 = 0;
        y2 = 0;
        y1 = 0;
    }

    public MyLine(Color shapeColor, int x1, int y1,int x2,int y2) {
        this.shapeColor = shapeColor;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public void draw(Graphics g){
             g.setColor(shapeColor);
            g.drawLine(x1,y1,x2,y2);
    }

    @Override
    public void setX1(int x1) {
        this.x1 = x1;
    }

    @Override
    public void setY1(int y1) {
        this.y1 = y1;
    }

    @Override
    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public void setX2(int x2) {
        this.x2 = x2;
    }

    @Override
    public Color getShapeColor() {
        return shapeColor;
    }

    @Override
    public void setShapeColor(Color shapeColor) {

        this.shapeColor = shapeColor;
    }

    @Override
    public int getX1() {
        return x1;
    }


    @Override
    public int getY1() {
        return y1;
    }

    @Override
    public int getX2() {
        return x2;
    }

    @Override
    public int getY2() {
        return y2;
    }
}
