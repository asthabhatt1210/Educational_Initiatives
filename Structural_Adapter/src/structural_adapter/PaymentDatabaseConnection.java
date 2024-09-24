package structural_adapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PaymentDatabaseConnection {
      private static PaymentDatabaseConnection instance;
    private Connection connection;

    private PaymentDatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/structural_adapter", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static PaymentDatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new PaymentDatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new PaymentDatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
