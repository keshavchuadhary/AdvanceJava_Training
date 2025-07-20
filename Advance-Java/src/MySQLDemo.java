import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLDemo {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/mysql" // Connect to default mysql db
                       + "?useSSL=false"
                       + "&serverTimezone=UTC";
        
        String username = "root";
        String password = "your_password"; // Replace with your password
        
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT version()")) {
            
            if (rs.next()) {
                System.out.println("Connected to MySQL version: " + rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}