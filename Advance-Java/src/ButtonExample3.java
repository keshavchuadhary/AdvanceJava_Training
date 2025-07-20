import javax.swing.*;

public class ButtonExample3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lambda ActionListener");
        JButton button = new JButton("Click Me!");
        
        // Method 3: Using lambda expression
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Lambda expression works!");
        });
        
        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}