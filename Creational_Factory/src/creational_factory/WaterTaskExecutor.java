package creational_factory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WaterTaskExecutor implements CropTaskExecutor{
   public void executeTask(String crop) throws SQLException {
        ensureCropExists(crop);  // Check or insert crop in the database
        try (Connection connection = AgriculturalDatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement("UPDATE crops SET last_watered = NOW() WHERE name = ?")) {
            stmt.setString(1, crop);
            stmt.executeUpdate();
            System.out.println("Watered crop: " + crop);
        }
    }
}
