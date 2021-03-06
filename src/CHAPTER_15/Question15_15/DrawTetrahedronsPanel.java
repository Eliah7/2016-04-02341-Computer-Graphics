package CHAPTER_15.Question15_15;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

/**
 * Created by eliahmbwilo on 12/2/17.
 */
public class DrawTetrahedronsPanel extends JPanel {

    public DrawTetrahedronsPanel() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int baseX[] = {110, 150, 50, 110};
        int baseY[] = {90, 130, 130, 90};

        int x = 110, y = 40;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);

        GeneralPath tetrahedron = new GeneralPath();

        tetrahedron.moveTo(baseX[0], baseY[0]);
        for (int i = 1; i < 4; i++) {
            tetrahedron.lineTo(x, y);
            tetrahedron.moveTo(baseX[i - 1], baseY[i - 1]);
            tetrahedron.lineTo(baseX[i], baseY[i]);
        }
        tetrahedron.closePath();

        g2d.draw(tetrahedron);


    }

}
