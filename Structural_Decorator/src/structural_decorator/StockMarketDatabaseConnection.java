package structural_decorator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StockMarketDatabaseConnection {
    private static StockMarketDatabaseConnection instance;
    private Connection connection;

    private StockMarketDatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/structural_decorator", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static StockMarketDatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new StockMarketDatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new StockMarketDatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
