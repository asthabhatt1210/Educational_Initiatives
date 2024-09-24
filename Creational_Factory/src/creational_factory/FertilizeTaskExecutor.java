package creational_factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FertilizeTaskExecutor implements CropTaskExecutor{

    @Override
     public void executeTask(String crop) throws SQLException {
        ensureCropExists(crop);  // Check or insert crop in the database
        try (Connection connection = AgriculturalDatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement("UPDATE crops SET last_fertilized = NOW() WHERE name = ?")) {
            stmt.setString(1, crop);
            stmt.executeUpdate();
            System.out.println("Fertilized crop: " + crop);
        }
    }
}
