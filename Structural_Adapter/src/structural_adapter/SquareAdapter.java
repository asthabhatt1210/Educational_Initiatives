package structural_adapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SquareAdapter implements PaymentProcessor  {
    @Override
    public void processPayment(double amount) throws SQLException {
        System.out.println("Processing payment of " + amount + " through Square.");
        try (Connection connection = PaymentDatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO payments (gateway, amount) VALUES (?, ?)")) {
            stmt.setString(1, "Square");
            stmt.setDouble(2, amount);
            stmt.executeUpdate();
        }
    }
}
