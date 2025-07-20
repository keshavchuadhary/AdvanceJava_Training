import javax.swing.*;
import java.awt.event.*;

public class WindowAdapterExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("WindowAdapter Demo");
        frame.setSize(400, 300);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Window opened");
            }
            
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                    frame, 
                    "Are you sure you want to exit?",
                    "Exit Confirmation",
                    JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    System.out.println("Window closing - application exiting");
                    System.exit(0);
                }
            }
            
            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("Window gained focus");
            }
        });
        
        frame.setVisible(true);
    }
}