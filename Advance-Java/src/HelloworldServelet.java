import java.awt.*;
import javax.swing.*;

public class HelloworldServelet {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
        JFrame frame = new Helloworld();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Welcome to advance java programming");
        frame.setVisible(true);
        });
    }
}

class Helloworld extends JFrame   {

    public Helloworld()
    {
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);
    }
}