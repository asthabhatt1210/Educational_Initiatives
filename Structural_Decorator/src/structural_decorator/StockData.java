package structural_decorator;
import java.sql.SQLException;

public interface StockData {
    void getStockData(String symbol) throws SQLException;
}
