package creational_singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MedicalDatabaseConnection {
    private static MedicalDatabaseConnection instance;
    private Connection connection;

    private MedicalDatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/creational_singleton", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static MedicalDatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new MedicalDatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new MedicalDatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
