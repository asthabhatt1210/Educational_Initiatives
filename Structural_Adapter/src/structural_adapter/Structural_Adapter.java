package structural_adapter;
import java.sql.SQLException;
import java.util.Scanner;

public class Structural_Adapter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Payment Gateway (PayPal/Stripe/Square):");
        String gateway = scanner.nextLine();

        System.out.println("Enter Payment Amount:");
        double amount = scanner.nextDouble();

        PaymentProcessor paymentProcessor;
        switch (gateway.toLowerCase()) {
            case "paypal":
                paymentProcessor = new PayPalAdapter();
                break;
            case "stripe":
                paymentProcessor = new StripeAdapter();
                break;
            case "square":
                paymentProcessor = new SquareAdapter();
                break;
            default:
                throw new IllegalArgumentException("Unknown payment gateway: " + gateway);
        }

        try {
            paymentProcessor.processPayment(amount);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
