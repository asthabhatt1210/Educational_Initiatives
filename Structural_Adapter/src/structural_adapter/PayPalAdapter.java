package structural_adapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PayPalAdapter implements PaymentProcessor{

    @Override
    public void processPayment(double amount) throws SQLException {
   System.out.println("Processing payment of " + amount + " through PayPal.");
        try (Connection connection = PaymentDatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO payments (gateway, amount) VALUES (?, ?)")) {
            stmt.setString(1, "PayPal");
            stmt.setDouble(2, amount);
            stmt.executeUpdate();
        }
    }
}
