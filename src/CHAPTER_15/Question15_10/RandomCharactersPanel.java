package CHAPTER_15.Question15_10;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by eliahmbwilo on 12/1/17.
 */
public class RandomCharactersPanel extends JPanel {
    public static final int X_TOP = 300;
    public static final int Y_TOP = 200;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    public Font fonts[] = {new Font("Sarif", Font.BOLD, generateRandomInt()),
            new Font("Serif", Font.ITALIC, generateRandomInt()),
            new Font("Serif", Font.PLAIN, generateRandomInt()),
            new Font("SansSerif", Font.BOLD, generateRandomInt()),
            new Font("SansSerif", Font.ITALIC, generateRandomInt()),
            new Font("SansSerif", Font.PLAIN, generateRandomInt()),
            new Font("Monospaced", Font.BOLD, generateRandomInt()),
            new Font("Monospaced", Font.ITALIC, generateRandomInt()),
            new Font("Monospaced", Font.PLAIN, generateRandomInt()),
    };

    char aChar[] = {
            'a','b','c','b','e',
            'f','g','h','i','j',
            'k','l','m','n','o',
            'p','q','r','s','t',
            'u','v','w','x','y',
            'z','/',';','1','2',
            '3','4','5','6','7',
            '8','9','0','-','+',
            '+'
    };

    public RandomCharactersPanel() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0;i <aChar.length;i++){
            g.setFont(fonts[generateRandomFontInt()]);
            g.setColor(new Color(generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat(), generateRandomColorFloat()));
            g.drawString(Character.toString(aChar[generateRandomIntChar()]), generateRandomIntX(), generateRandomIntY());

        }


    }

    private int generateRandomIntChar() {
        Random rand = new Random();
        int n = rand.nextInt(fonts.length);
        return n;
    }

    public float generateRandomColorFloat() { // generate a random number from 0.0 to 1.0
        Random rand = new Random();
        float n = rand.nextFloat();
        return n;
    }

    public int generateRandomInt() {  // generate a random number from 1 to 1000
        Random rand = new Random();
        int n = rand.nextInt(250) + 1;
        return n;
    }

    public  int generateRandomIntX(){
        Random rand = new Random();
        int n = rand.nextInt(500) + 50;
        return n;
    }

    public  int generateRandomIntY(){
        Random rand = new Random();
        int n = rand.nextInt(400) + 50;
        return n;
    }
    public int generateRandomFontInt() {
        Random random = new Random();
        int n = random.nextInt(fonts.length);
        return n;
    }
}
