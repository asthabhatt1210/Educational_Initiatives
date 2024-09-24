package structural_decorator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockAlertDecorator extends StockDataDecorator {
     public StockAlertDecorator(StockData decoratedStockData) {
        super(decoratedStockData);
    }
    public void getStockData(String symbol) throws SQLException {
        super.getStockData(symbol);
        System.out.println("Setting alerts for " + symbol + "...");
        try (Connection connection = StockMarketDatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO stock_data (symbol, feature) VALUES (?, ?)")) {
            stmt.setString(1, symbol);
            stmt.setString(2, "Alerts");
            stmt.executeUpdate();
        }
    }
}
