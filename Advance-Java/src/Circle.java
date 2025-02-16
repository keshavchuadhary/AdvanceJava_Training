//Import the required packages.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class javacircle extends JFrame {
    public javacircle() {
        setTitle("JAVA PROGRAM TO DRAW A CIRCLE");
        // Declare the height and the width of the window.
        setSize(400, 400);
        // Set the visibility as true.
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    // The graphics in Java
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // Set the axis with height and weight.
        g2d.fillOval(80, 80, 150, 150);
        // Set the color to be black.
        g2d.setPaint(Color.black);
    }
    // The main class in Java.
    public static void main(String[] args) {
        // Calling the object created to display the circle.
        javacircle frames = new javacircle();
        frames.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
        // Set the size of the frame.
        frames.setSize(400, 400);
        // Set the visibility of the frame.
        frames.setVisible(true);

    }
}