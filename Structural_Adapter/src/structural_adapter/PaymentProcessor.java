package structural_adapter;
import java.sql.SQLException;

public interface PaymentProcessor {
    void processPayment(double amount) throws SQLException;
}
