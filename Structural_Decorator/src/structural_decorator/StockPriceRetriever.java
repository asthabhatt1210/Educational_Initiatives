package structural_decorator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockPriceRetriever implements StockData{
     public void getStockData(String symbol) throws SQLException {
        System.out.println("Retrieving stock data for " + symbol + "...");
        try (Connection connection = StockMarketDatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO stock_data (symbol, feature) VALUES (?, ?)")) {
            stmt.setString(1, symbol);
            stmt.setString(2, "Basic Stock Data");
            stmt.executeUpdate();
        }
    }
}
