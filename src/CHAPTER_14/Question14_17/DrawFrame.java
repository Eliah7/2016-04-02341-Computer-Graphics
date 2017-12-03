package CHAPTER_14.Question14_17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by eliahmbwilo on 11/19/17.
 */
public class DrawFrame extends JFrame {
    public static final int X_TOP = 300;
    public static final int Y_TOP = 200;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    JButton btnUndo;
    JButton btnClear;

    JComboBox<String> cmbColor;
    JComboBox<String> cmbShape;
    JCheckBox filled;

    DrawPanel drawingPanel;
    JPanel componentsPanel;


    Color color;


    public static void main(String args[]) {
        // code to launch the gui frame
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new DrawFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(X_TOP, Y_TOP, WIDTH, HEIGHT);
                frame.setTitle("Java Drawings");
                frame.setVisible(true);
            }
        });
    }

    public DrawFrame() {
        String[] colors = {"Red", "Blue", "Black", "Green", "Pink"};
        String[] shapes = {"Rectangle", "Line", "Oval"};

        btnClear = new JButton("Clear");
        btnUndo = new JButton("Undo");

        cmbColor = new JComboBox<>(colors);  // list of strings of color
        cmbColor.setMaximumRowCount(5);
        cmbShape = new JComboBox<>(shapes);   // list of strings of shapes
        cmbShape.setMaximumRowCount(5);



        filled = new JCheckBox("filled");
        setLayout(new BorderLayout());

        drawingPanel = new DrawPanel();

        // enable filling and not filling the shapes
        filled.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (filled.isSelected()){
                    drawingPanel.setFilledShape(true);
                    drawingPanel.updateShapeFilled(true);
                    drawingPanel.repaint();
                }else {
                    drawingPanel.setFilledShape(false);
                    drawingPanel.updateShapeFilled(false);
                    drawingPanel.repaint();
                }
            }
        });

        // listener to the combo box to select color
        cmbColor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    switch (cmbColor.getSelectedIndex()) {
                        case 0:
                            color = Color.RED;
                            drawingPanel.setCurrentColor(color);
                            drawingPanel.updateShapeColor(color);
                            drawingPanel.repaint();
                            break;
                        case 1:
                            color = Color.BLUE;
                            drawingPanel.setCurrentColor(color);
                            drawingPanel.updateShapeColor(color);
                            drawingPanel.repaint();
                            break;
                        case 2:
                            color = Color.BLACK;
                            drawingPanel.setCurrentColor(color);
                            drawingPanel.updateShapeColor(color);
                            drawingPanel.repaint();
                            break;
                        case 3:
                            color = Color.GREEN;
                            drawingPanel.setCurrentColor(color);
                            drawingPanel.updateShapeColor(color);
                            drawingPanel.repaint();
                            break;
                        case 4:
                            color = Color.PINK;
                            drawingPanel.setCurrentColor(color);
                            drawingPanel.updateShapeColor(color);
                            drawingPanel.repaint();
                            break;
                        default:
                            color = Color.black;
                            drawingPanel.setCurrentColor(color);
                            drawingPanel.updateShapeColor(color);
                            drawingPanel.repaint();
                            break;
                    }
                }
            }
        });

        //add a listener for the kind of shape the user is drawing
        cmbShape.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    switch (cmbShape.getSelectedIndex()) {
                        case 0:
                            drawingPanel.setShapeType(0);
                            drawingPanel.updateShapeType(0);
                            drawingPanel.repaint();
                            break;
                        case 1:
                            drawingPanel.setShapeType(1);
                            drawingPanel.updateShapeType(1);
                            drawingPanel.repaint();
                            break;
                        case 2:
                            drawingPanel.setShapeType(2);
                            drawingPanel.updateShapeType(2);
                            drawingPanel.repaint();
                            break;
                        default:
                            drawingPanel.setShapeType(2);
                            drawingPanel.updateShapeType(2);
                            drawingPanel.repaint();
                            break;
                    }
                }
            }
        });



        componentsPanel = new JPanel(new FlowLayout());

        drawingPanel.setBackground(Color.WHITE);  // set the background of the drawing panel to white

        componentsPanel.add(btnUndo);
        componentsPanel.add(btnClear);
        componentsPanel.add(cmbColor);
        componentsPanel.add(cmbShape);
        componentsPanel.add(filled);

        add(componentsPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);


        //adding listener to the buttons
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.clearDrawing();
            }
        });

        btnUndo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.clearLastShape();
            }
        });
    }
}



