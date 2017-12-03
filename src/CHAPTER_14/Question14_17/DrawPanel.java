package CHAPTER_14.Question14_17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by eliahmbwilo on 11/19/17.
 */
public class DrawPanel extends JPanel {
    private MyShape shapes[];
    private int shapeCount;
    private int shapeType;
    private MyShape currentShape;
    private Color currentColor;
    private boolean filledShape;
    private JLabel statusBar;

    public DrawPanel() {
        // start by drawing a line
        currentShape = null;
        currentColor = Color.red;  // default color


        shapeCount = 0;  // number of shapes the user wants to draw
        shapes = new MyShape[100];   // array of said shapes

        setLayout(new BorderLayout());
        statusBar = new JLabel("(0,0)");

        setBackground(Color.WHITE);

        add(statusBar, BorderLayout.SOUTH);
        addMouseListener(new MouseActions());
        addMouseMotionListener(new MouseActions());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //allowing for the user to draw more than one shape in this method since it gets called every time the panel is redrawn


        for (int i = 0; i < shapeCount; i++) {   // draw all the shapes in this array
            shapes[i].draw(g);
        }

        if (currentShape != null) {
            currentShape.draw(g);
        }

    }

    @Override
    public void repaint(Rectangle r) {
        super.repaint(r);

    }

    public void updateShapeColor(Color color) {
        if (currentShape != null) {
            currentShape.setShapeColor(color);
            repaint();
        }
    }

    public void updateShapeType(int shapeType) {
        if (currentShape != null) {
            switch (shapeType) {
                case 0:
                    currentShape = new MyRectangle(currentShape.getShapeColor(), currentShape.getX1(), currentShape.getY1(), currentShape.getX2(), currentShape.getY2(), filledShape);

                    break;
                case 1:
                    currentShape = new MyLine(currentShape.getShapeColor(), currentShape.getX1(), currentShape.getY1(), currentShape.getX2(), currentShape.getY2());

                    break;
                case 2:
                    currentShape = new MyOval(currentShape.getShapeColor(), currentShape.getX1(), currentShape.getY1(), currentShape.getX2(), currentShape.getY2(), filledShape);

                    break;
                default:
                    currentShape = new MyRectangle();

                    break;

            }
        }

        repaint();
    }

    public void updateShapeFilled(boolean filledShape) {
        if (currentShape != null) {
            setFilledShape(filledShape);
            currentShape.setFilled(filledShape);
        }
        repaint();
    }

    public void setShapeType(int shapeType) {
        this.shapeType = shapeType;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public void setFilledShape(boolean filledShape) {
        this.filledShape = filledShape;
    }

    public void clearDrawing() { //
        shapeCount = 0;
        shapes = new MyShape[100];
        repaint();
    }

    public void clearLastShape() {
        // remove the last drawn shape
        if (shapeCount != 0) {
            shapeCount--;
        }
        repaint();
    }


    class MouseActions extends MouseAdapter implements MouseMotionListener {

        public MouseActions() {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);  // create a new shape

            switch (shapeType) {
                case 0:
                    currentShape = new MyRectangle();
                    currentShape.setFilled(filledShape);
                    currentShape.setShapeColor(currentColor);
                    break;
                case 1:
                    currentShape = new MyLine();
                    currentShape.setShapeColor(currentColor);
                    break;
                case 2:
                    currentShape = new MyOval();
                    currentShape.setFilled(filledShape);
                    currentShape.setShapeColor(currentColor);

                    break;
                default:
                    currentShape = new MyRectangle();

                    break;

            }

            currentShape.setX1(e.getX());
            currentShape.setY1(e.getY());


            // statusBar.setText("Mouse pressed");
        }


        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);   // finish drawing the shape and add it to the array
            currentShape.setX2(e.getX());
            currentShape.setY2(e.getY());


            //statusBar.setText("Mouse Released");

            shapes[shapeCount] = currentShape;
            if (shapeCount != 100) {
                shapeCount++;
            } else {
                statusBar.setText("OOps you can only draw 100 drawings at time !");
            }


            repaint();
            currentShape = null;
            // remove the pointer to the already drawn shape
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);  // to display the coordinates of the mouse

            statusBar.setText("(" + Integer.toString(e.getX()) + "," + Integer.toString(e.getY()) + ")");
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);   // collect the second set of coordinates
            currentShape.setX2(e.getX());
            currentShape.setY2(e.getY());
            currentShape.setShapeColor(currentColor);
            // statusBar.setText("Mouse Dragged");
            repaint();

        }
    }

}
