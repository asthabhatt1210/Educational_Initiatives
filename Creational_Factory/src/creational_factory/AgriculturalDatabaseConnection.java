package creational_factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AgriculturalDatabaseConnection {
    private static AgriculturalDatabaseConnection instance;
    private Connection connection;

    private AgriculturalDatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/creational_factory", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static AgriculturalDatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new AgriculturalDatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new AgriculturalDatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
