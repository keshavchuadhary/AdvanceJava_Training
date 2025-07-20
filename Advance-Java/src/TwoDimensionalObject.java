import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TwoDimensionalObject extends JPanel {
    public TwoDimensionalObject() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Draw a rectangle
        g2d.drawRect(10, 10, 50, 50);
        // Draw a line
        g2d.drawLine(30, 10, 30, 60);
        // Draw an ellipse
        Ellipse2D.Double ellipse = new Ellipse2D.Double(70, 10, 50, 50);
        g2d.draw(ellipse);
        // Draw a text
        g2d.drawString("Hello, World!", 20, 70);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Two Dimensional Object");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TwoDimensionalObject twoDimensionalObject = new TwoDimensionalObject();
        frame.add(twoDimensionalObject);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}