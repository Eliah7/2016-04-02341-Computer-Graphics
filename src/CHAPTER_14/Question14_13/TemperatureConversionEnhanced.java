package CHAPTER_14.Question14_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by root on 11/18/17.
 */
public class TemperatureConversionEnhanced {
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
    static JPanel panel3;
    static ButtonGroup btnGroup;
    static JRadioButton chooseCelcius;
    static JRadioButton chooseKelvin;
    static boolean celciusWanted;

    public TemperatureConversionFrame() {
        // instantiating the components
        textField = new JTextField(10);
        label = new JLabel("");
        lblLabel = new JLabel("The temperature in Celcius will be: ");
        lblTextField = new JLabel("Enter the temperature in Farenheight: ");
        chooseCelcius = new JRadioButton("To Celcius", false);
        chooseKelvin = new JRadioButton("To Kelvin", false);
        btnGroup = new ButtonGroup();
        btnGroup.add(chooseCelcius);
        btnGroup.add(chooseKelvin);

        panel = new JPanel(new GridLayout(3, 1));
        panel2 = new JPanel(new BorderLayout());
        panel3 = new JPanel(new GridLayout(1, 2));

        setLayout(new GridLayout(2, 1));

        panel3.add(chooseCelcius);
        panel3.add(chooseKelvin);

        panel.add(panel3);
        panel.add(lblTextField);
        panel.add(textField);


        panel2.add(lblLabel, BorderLayout.NORTH);
        panel2.add(label, BorderLayout.CENTER);

        add(panel);
        add(panel2);

        // adding event listeners
        textField.addActionListener(this);  // when the user presses the enter key
        chooseKelvin.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED){
                    celciusWanted = false;
                    computeTemp();
                    lblLabel.setText("The temperature in Kelvin will be: ");
                }
            }
        });

        chooseCelcius.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED){
                    celciusWanted = true;
                    computeTemp();
                    lblLabel.setText("The temperature in Celcius will be: ");
                }
            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent event) {

        try {
            if (event.getSource() == textField) {
              computeTemp();
            }
        } catch (NumberFormatException e) {    // a number format exception is thrown when a text is entered
            JOptionPane.showMessageDialog(null, "Please enter a number");
        }
    }

    public float calculateCelcius(int temp) {
        float tempCelcius = 5 * (temp - 32) / 9;
        return tempCelcius;
    }

    public float calculateKelvin(float inCelcius) {
        float inKelvin = inCelcius + 273.15F;
        return inKelvin;
    }

    public void computeTemp(){
        String text = textField.getText().trim();
        int temp = Integer.parseInt(text, 10);
        float tempCelcius = calculateCelcius(temp);
        if (celciusWanted) {
            label.setText(Float.toString(tempCelcius) + " C");
        }else {
            float tempKelvin = calculateKelvin(tempCelcius);
            label.setText(Float.toString(tempKelvin)+" K");
        }

    }

}


