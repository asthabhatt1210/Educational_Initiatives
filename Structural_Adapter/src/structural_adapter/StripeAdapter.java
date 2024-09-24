package structural_adapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StripeAdapter implements PaymentProcessor {
    @Override
    public void processPayment(double amount) throws SQLException {
        System.out.println("Processing payment of " + amount + " through Stripe.");
        try (Connection connection = PaymentDatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO payments (gateway, amount) VALUES (?, ?)")) {
            stmt.setString(1, "Stripe");
            stmt.setDouble(2, amount);
            stmt.executeUpdate();
        }
    }  
}
