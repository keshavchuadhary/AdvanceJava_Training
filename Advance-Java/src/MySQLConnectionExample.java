import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionExample {
    public static void main(String[] args) {
        // JDBC URL components
        String host = "localhost";
        String port = "3306";
        String database = "testdb";
        String username = "root";
        String password = "1111";
        
        // Build JDBC URL
        String jdbcUrl = "jdbc:mysql://" + host + ":" + port + "/" + database +
                         "?useSSL=false" + 
                         "&serverTimezone=UTC" +
                         "&characterEncoding=UTF-8";
        
        try {
            // Load MySQL JDBC driver (not required for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            
            System.out.println("Successfully connected to MySQL database!");
            
            // Use the connection for database operations...
            
            // Close connection when done
            connection.close();
            
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed!");
            e.printStackTrace();
        }
    }
}