package CHAPTER_15.Question15_27;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by eliahmbwilo on 12/3/17.
 */
public class PieChartFrame extends JFrame {
    // declaring and instantiating the dimension variables
    public static final int X_TOP = 300;
    public static final int Y_TOP = 200;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;
    private int count = 0;
    public int numbersEntered[];

    // declaring the component variables
    public PieChartPanel pieChartPanel;
    public JPanel txtPanel;
    JTextField txtnumber;
    JLabel label;


    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                PieChartFrame frame = new PieChartFrame();
                frame.setTitle("Pie Chart");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(X_TOP, Y_TOP, WIDTH, HEIGHT);
                frame.setResizable(true);
                frame.setVisible(true);
            }
        });
    }

    public PieChartFrame() {
        // instantiating the variables
        pieChartPanel = new PieChartPanel();
        txtPanel = new JPanel();
        txtnumber = new JTextField();
        label = new JLabel("Enter the first number");
        numbersEntered = new int[4];
        //setting the layouts
        pieChartPanel.setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        txtPanel.setLayout(new BorderLayout());
        // adding the components
        txtPanel.add(label, BorderLayout.NORTH);
        txtPanel.add(txtnumber, BorderLayout.CENTER);

        add(pieChartPanel, BorderLayout.CENTER);
        add(txtPanel, BorderLayout.NORTH);

        // implementing action listeners
        txtnumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                switch (count) {
                    case 1:
                        label.setText("Enter the Second number");
                        numbersEntered[0] = getEnteredNumber();
                        break;
                    case 2:
                        label.setText("Enter the Third number");
                        numbersEntered[1] = getEnteredNumber();
                        break;
                    case 3:
                        label.setText("Enter the Fourth number");
                        numbersEntered[2] = getEnteredNumber();
                        break;

                    case 4:
                        numbersEntered[3] = getEnteredNumber();
                        label.setText("Now displaying the pie chart");
                        txtnumber.setFocusable(false);
                        txtnumber.setEditable(false);
                        pieChartPanel.receiveArray(numbersEntered);
                        pieChartPanel.repaint();
                        break;
                }

            }
        });
    }

    public int getEnteredNumber() {
        try {
            String text = txtnumber.getText().trim();
            int temp = Integer.parseInt(text, 10);
            return temp;

        } catch (NumberFormatException e) {    // a number format exception is thrown when a text is entered
            if (txtnumber.getText() != "")
            JOptionPane.showMessageDialog(null, "Please enter a number");

        }
        return 0;
    }
}
