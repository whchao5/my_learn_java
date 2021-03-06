package bounce;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bounce {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class BounceFrame extends JFrame {

    private BallComponent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;


    public BounceFrame() {
        setTitle("Bounce");

        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> moreAddBall());
        addButton(buttonPanel, "close", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
    }

    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    // 单线程案例
    public void addBall() {

        try {

            Ball ball = new Ball();
            comp.add(ball);

            for (int i = 0; i <= STEPS; i++) {
                ball.move(comp.getBounds());
                comp.print(comp.getGraphics());
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {

        }
    }

    // 多线程案例
    public void moreAddBall() {

        Ball ball = new Ball();
        comp.add(ball);

        Runnable r = () -> {
            try {

                for (int i = 0; i <= STEPS; i++) {
                    ball.move(comp.getBounds());
                    comp.print(comp.getGraphics());
                    Thread.sleep(DELAY);
                }
            } catch (InterruptedException e) {

            }
        };

//        Runnable r  =  addBall();

        Thread t = new Thread(r);
        t.start();
    }
}