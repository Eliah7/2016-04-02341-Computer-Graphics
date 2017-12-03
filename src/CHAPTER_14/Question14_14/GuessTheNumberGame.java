package CHAPTER_14.Question14_14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by eliahmbwilo on 11/19/17.
 */
public class GuessTheNumberGame {
    public static final int X_TOP = 300;
    public static final int Y_TOP = 200;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    public static void main(String args[]) {
        // code to launch the gui frame
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new GuessTheNumberGameFrame();
                frame.setTitle("Guess The Number Game");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(X_TOP, Y_TOP, WIDTH, HEIGHT);
                frame.setVisible(true);
            }
        });
    }
}

class GuessTheNumberGameFrame extends JFrame implements ActionListener {
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel mainPanel;

    JLabel lblQn;
    JLabel lblResponce;
    JTextField txtAnswer;
    JButton btnReplay;

    FlowLayout layout;
    int random = generateRandomInt();
    boolean isLow;

    public GuessTheNumberGameFrame() {
        // instantiating the components of the GUI frame
        panel1  = new JPanel(new GridLayout(2,1));
        panel2 = new JPanel(new BorderLayout());
        panel3 = new JPanel();
        mainPanel = new JPanel(new GridLayout(2,1));

        layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);

        lblQn = new JLabel("I have a number between 1 and 1000.Can you guess my number ?");
        lblResponce = new JLabel("");

        txtAnswer = new JTextField();
        btnReplay = new JButton("Play Again !");

        panel1.add(lblQn);
        panel1.add(lblResponce);

        panel3.setLayout(layout);
        panel3.add(btnReplay);
        btnReplay.setVisible(false);

        panel2.add(txtAnswer,BorderLayout.CENTER);
        panel2.add(panel3,BorderLayout.EAST);

        mainPanel.add(panel1);
        mainPanel.add(panel2);

        add(mainPanel);

        // adding action listeners
        txtAnswer.addActionListener(this);
        btnReplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                lblResponce.setText("");
                btnReplay.setVisible(false);
                txtAnswer.setEditable(true);
                random = generateRandomInt();
            }
        });

    }

    public int generateRandomInt(){  // generate a random number from 1 to 1000
        Random rand = new Random();
        int n = rand.nextInt(1000) + 1;
        return n;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == txtAnswer){
            try{
                String text = txtAnswer.getText().trim();
                int temp = Integer.parseInt(text, 10);
                compareNumbers(temp);
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter a number");
            }
        }
    }



    public void compareNumbers(int entered){
        if (entered == random){
            lblResponce.setText("Correct");
            btnReplay.setVisible(true);
            txtAnswer.setEditable(false);
        }else {
            if ((entered-random) > 0){
                lblResponce.setText("Too high !");
                isLow = false;

            }else {
                lblResponce.setText("Too Low !");
                isLow = true;
            }
        }
    }

}
