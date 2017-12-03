package CHAPTER_14.Question14_9;

import javax.swing.*;
import java.awt.*;

/**
 * Created by root on 11/18/17.
 */
public class CalculatorFrameTest {
    public static final int X_TOP = 300;
    public static final int Y_TOP = 200;
    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;

    public static void main(String args[]) {

        // code to launch the calculator frame
        EventQueue.invokeLater(new Runnable() {  // run the GUI frame in the event-dispatch thread and not the main thread
            @Override
            public void run() {
                JFrame frame = new CalculatorFrame();
                frame.setTitle("Calculator");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(X_TOP, Y_TOP, WIDTH, HEIGHT);
                frame.setVisible(true);
            }
        });
    }


}

class CalculatorFrame extends JFrame {

    //declaring the necessary variables to be used in the Calculator program
    JPanel panelMain;
    JPanel panelButtons;

    //Text field to display the results
    JTextField numberField;

    //Necessary buttons
    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;

    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;

    JButton button8;
    JButton button9;
    JButton buttonDivide;
    JButton buttonMultiply;

    JButton buttonMinus;
    JButton buttonAdd;
    JButton buttonEqual;
    JButton buttonDecimal;


    public CalculatorFrame() {
        // instantiating the variables
        panelMain = new JPanel(new BorderLayout());
        panelButtons = new JPanel(new GridLayout(4, 4));

        numberField = new JTextField(1);

        // use arrays
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");

        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");

        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonDivide = new JButton("/");
        buttonMultiply = new JButton("*");

        buttonMinus = new JButton("-");
        buttonAdd = new JButton("+");
        buttonEqual = new JButton("=");
        buttonDecimal = new JButton(".");

        panelButtons.add(button7);
        panelButtons.add(button8);
        panelButtons.add(button9);
        panelButtons.add(buttonDivide);

        panelButtons.add(button4);
        panelButtons.add(button5);
        panelButtons.add(button6);
        panelButtons.add(buttonMultiply);

        panelButtons.add(button1);
        panelButtons.add(button2);
        panelButtons.add(button3);
        panelButtons.add(buttonMinus);

        panelButtons.add(button0);
        panelButtons.add(buttonDecimal);
        panelButtons.add(buttonEqual);
        panelButtons.add(buttonAdd);


//        panelMain.add(numberField);
//        panelMain.add(panelButtons);
        panelMain.add(numberField, BorderLayout.NORTH);
        panelMain.add(panelButtons, BorderLayout.CENTER);

        add(panelMain);
    }

}
