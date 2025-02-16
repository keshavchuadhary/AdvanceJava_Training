import java.awt.Dimension;

public class Java {
    public static void main(String[] args) {
        // Instantiate the inner class (NotHelloWorld)
        NotHelloWorld obj = new NotHelloWorld();
        // Get preferred size of the object
        Dimension preferredSize = obj.getPreferredSize();
        System.out.println("Preferred size: " + preferredSize);
    }

    // Make NotHelloWorld class static since it's used inside a static context
    public static class NotHelloWorld extends Java {
        public static final int DEFAULT_WIDTH = 75;
        public static final int DEFAULT_HEIGHT = 150;

        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_HEIGHT, DEFAULT_WIDTH);
        }
    }
}