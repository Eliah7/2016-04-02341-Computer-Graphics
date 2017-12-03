package CHAPTER_14.Question14_17;

import java.awt.*;

/**
 * Created by eliahmbwilo on 11/19/17.
 */
public abstract class MyShape {
    private Color shapeColor;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private boolean isFilled;

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public MyShape() {  // a no argument constructor
        shapeColor = Color.black;
        x1 = 0;
        x2 = 0;
        y2 = 0;
        y1 = 0;
    }

    public MyShape(Color shapeColor, int x1, int y1,int x2,int y2) {
        this.shapeColor = shapeColor;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public Color getShapeColor() {

        return shapeColor;
    }

    public void setShapeColor(Color currentColor) {
        this.shapeColor = shapeColor;
    }

    public abstract void draw(Graphics g);


}
