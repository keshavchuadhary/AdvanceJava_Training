import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class MouseAdapterEX extends JPanel {
    private List<Point> circles = new ArrayList<>();
    
    public MouseAdapterEX() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                circles.add(new Point(e.getX(), e.getY()));
                repaint();
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for (Point p : circles) {
            g.fillOval(p.x - 15, p.y - 15, 30, 30);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mouse Adapter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            frame.add(new MouseAdapterEX());
            frame.setVisible(true);
        });
    }
}