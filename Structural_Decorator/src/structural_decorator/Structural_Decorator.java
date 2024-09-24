package structural_decorator;
import java.util.*;
import java.sql.SQLException;
public class Structural_Decorator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Stock Symbol:");
        String symbol = scanner.nextLine();

        StockData stockData = new StockPriceRetriever();

        System.out.println("Do you want to add Charting? (yes/no)");
        String charting = scanner.nextLine();
        if (charting.equalsIgnoreCase("yes")) {
            stockData = new StockChartDecorator(stockData);
        }

        System.out.println("Do you want to add Alerts? (yes/no)");
        String alerts = scanner.nextLine();
        if (alerts.equalsIgnoreCase("yes")) {
            stockData = new StockAlertDecorator(stockData);
        }

        try {
            stockData.getStockData(symbol);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
    
}
