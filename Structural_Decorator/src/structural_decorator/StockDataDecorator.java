package structural_decorator;
import java.sql.SQLException;

public class StockDataDecorator implements StockData {
      protected StockData decoratedStockData;

    public StockDataDecorator(StockData decoratedStockData) {
        this.decoratedStockData = decoratedStockData;
    }

    public void getStockData(String symbol) throws SQLException {
        decoratedStockData.getStockData(symbol);
    }
}
