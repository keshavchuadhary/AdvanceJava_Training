import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class DrawTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new DrawFrame();
            frame.setTitle("DrawTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
    
}

class DrawFrame extends JFrame{
    public DrawFrame(){
       add(new DrawComponent());
       pack();
    }
}

class DrawComponent extends JComponent{
    public static final int DEFAULT_WIDTH = 400 ;
    public static final int DEFAULT_HEIGHT= 400 ;

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        double leftX =100;
        double topY =100;
        double height =100;
        double width=100;
       
        Rectangle2D rect = new Rectangle2D.Double(leftX,topY,width,height);
        g2.draw(rect);

        //Draw enclosed ellipse 
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);

        g2.draw(new Line2D.Double(leftX,topY,leftX+width,topY+height));

          // draw a circle with \the same color
          double centerX = rect.getCenterX();
          double centerY = rect.getCenterY();
          double radius =  150 ; 

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX,centerY,centerX+radius,centerX+radius);
        g2.draw(circle);
    }

     public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
     }

}