package CHAPTER_14.Question14_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by root on 11/18/17.
 */
public class TemperatureConversion {
    public static final int X_TOP = 300;
    public static final int Y_TOP = 200;
    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;


    public static void main(String args[]) {
        // code to launch the conversion program
        EventQueue.invokeLater(new Runnable() {  // run the GUI in the event-dispatch and not in the main thread
            @Override
            public void run() {
                JFrame frame = new TemperatureConversionFrame();
                frame.setTitle("Temperature Conversion");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(X_TOP, Y_TOP, WIDTH, HEIGHT);
                frame.setVisible(true);

            }
        });

    }
}

class TemperatureConversionFrame extends JFrame implements ActionListener {
    //declaring the components of the Temp conversion program
    static JTextField textField;
    static JLabel label;
    static JLabel lblTextField;
    static JLabel lblLabel;
    static JPanel panel;
    static JPanel panel2;
    static JOptionPane optionPane;

    public TemperatureConversionFrame() {
        // instantiating the components
        textField = new JTextField(10);
        label = new JLabel("");
        lblLabel = new JLabel("The temperature in Celcius will be: ");
        lblTextField = new JLabel("Enter the temperature in Farenheight: ");

        panel = new JPanel(new BorderLayout());
        panel2 = new JPanel(new BorderLayout());

        setLayout(new GridLayout(2, 1));

        panel.add(textField, BorderLayout.CENTER);
        panel.add(lblTextField, BorderLayout.NORTH);

        panel2.add(lblLabel, BorderLayout.NORTH);
        panel2.add(label, BorderLayout.CENTER);

        add(panel);
        add(panel2);

        // adding event listeners
        textField.addActionListener(this);  // when the user presses the enter key

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        try {
            if (event.getSource() == textField) {
                String text = textField.getText().trim();
                int temp = Integer.parseInt(text, 10);
                float tempCelcius = 5 * (temp - 32) / 9;
                label.setText(Float.toString(tempCelcius)+" C");
            }
        } catch (NumberFormatException e) {    // a number format exception is thrown when a text is entered
            JOptionPane.showMessageDialog(null,"Please enter a number");
        }
    }
}

