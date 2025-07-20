import java.sql.*;

public class PreparedStatementExample {
    public static void main(String[] args) {
        // Use try-with-resources for automatic resource management
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydatabase", 
                "username", 
                "password")) {
            
            String query = "SELECT * FROM users WHERE name = ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, "John");  // Set parameter value
                
                try (ResultSet rs = pstmt.executeQuery()) {
                    // Process the result set
                    while (rs.next()) {
                        System.out.println(rs.getString("name"));
                    }
                }
            }
        } catch (SQLException e) {
            // Properly handle SQL exceptions
            System.err.println("Database error occurred:");
            e.printStackTrace();
        }
    }
}