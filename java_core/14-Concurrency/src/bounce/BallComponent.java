package bounce;

import java.awt.*;
import java.util.*;
import javax.swing.*;


/**
 * The component that draws the balls.
 *
 * @author Cay Horstmann
 * @version 1.34 2012-01-26
 */
public class BallComponent extends JPanel {

    private static final int DEFAULT_WIDTH  = 450;
    private static final int DEFAULT_HEIGHT = 350;

    private ArrayList<Ball> balls = new ArrayList<>();

    public void add(Ball b) {
        balls.add(b);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g); // erase background
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls)
        {
            g2.fill(b.getShape());
        }

    }



    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

}
