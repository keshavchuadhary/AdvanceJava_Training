import java.sql.*;

public class SimpleJDBCExample {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // 1. Load the JDBC driver (not required for newer JDBC versions)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
            return;
        }

        // 2. Establish connection
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to database successfully!");

            // Create table if not exists
            createTable(connection);

            // Insert data
            insertData(connection, 1, "John Doe", "john@example.com");
            insertData(connection, 2, "Jane Smith", "jane@example.com");

            // Read data
            readData(connection);

            // Update data
            updateData(connection, 1, "Johnathan Doe");

            // Delete data
            deleteData(connection, 2);

            // Read data again to see changes
            readData(connection);

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                     "id INT PRIMARY KEY, " +
                     "name VARCHAR(50), " +
                     "email VARCHAR(50))";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table created successfully");
        }
    }

    private static void insertData(Connection connection, int id, String name, String email) throws SQLException {
        String sql = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.executeUpdate();
            System.out.println("Data inserted successfully");
        }
    }

    private static void readData(Connection connection) throws SQLException {
        String sql = "SELECT * FROM users";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("\nCurrent data in users table:");
            System.out.println("ID\tName\t\tEmail");
            System.out.println("--------------------------------");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println(id + "\t" + name + "\t" + email);
            }
        }
    }

    private static void updateData(Connection connection, int id, String newName) throws SQLException {
        String sql = "UPDATE users SET name = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newName);
            statement.setInt(2, id);
            int rowsAffected = statement.executeUpdate();
            System.out.println("\nUpdated " + rowsAffected + " row(s)");
        }
    }

    private static void deleteData(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            System.out.println("\nDeleted " + rowsAffected + " row(s)");
        }
    }
}