import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SumDifferenceGUI {
    JFrame frame;
    JTextField num1;
    JTextField num2;
    JTextField result;

    

    public void createGUI() {
        frame = new JFrame("Sum and Difference Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        num1 = new JTextField(10);
        num2 = new JTextField(10);
        result = new JTextField(10);

        frame.add(new JLabel("Number 1:"));
        frame.add(num1);
        frame.add(new JLabel("Number 2:"));
        frame.add(num2);
        frame.add(new JLabel("Result:"));
        frame.add(result);

        num1.addMouseListener(new NumMouseListener());
        num2.addMouseListener(new NumMouseListener());

        frame.pack();
        frame.setVisible(true);
    }

    public class NumMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            try {
                int num1Value = Integer.parseInt(num1.getText());
                int num2Value = Integer.parseInt(num2.getText());
                int sum = num1Value + num2Value;
                result.setText("Sum: " + sum);
            } catch (NumberFormatException ex) {
                result.setText("Invalid input");
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            try {
                int num1Value = Integer.parseInt(num1.getText());
                int num2Value = Integer.parseInt(num2.getText());
                int difference = num1Value - num2Value;
                result.setText("Difference: " + difference);
            } catch (NumberFormatException ex) {
                result.setText("Invalid input");
            }
        }
    }

    public SumDifferenceGUI() {
        createGUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SumDifferenceGUI();
            }
        });
    }
}