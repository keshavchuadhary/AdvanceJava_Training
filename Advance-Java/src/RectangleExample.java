import javax.swing.*;
import java.awt.*;

public class RectangleExample extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set the color for the rectangle
        g.setColor(Color.BLUE);
        // Draw the rectangle (x, y, width, height)
        g.fillRect(50, 50, 200, 100);
    }

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Rectangle Drawing Example");
        RectangleExample rectanglePanel = new RectangleExample();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(rectanglePanel);
        frame.setVisible(true);
    }
}
