package creational_factory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;

public interface CropTaskExecutor {
    void executeTask(String crop) throws SQLException;
    
    // Helper method to ensure the crop exists in the database
    default void ensureCropExists(String crop) throws SQLException {
        Connection connection = AgriculturalDatabaseConnection.getInstance().getConnection();
        PreparedStatement checkStmt = connection.prepareStatement("SELECT name FROM crops WHERE name = ?");
        checkStmt.setString(1, crop);
        ResultSet rs = checkStmt.executeQuery();

        if (!rs.next()) {
            // Insert crop if it doesn't exist
            PreparedStatement insertStmt = connection.prepareStatement("INSERT INTO crops (name) VALUES (?)");
            insertStmt.setString(1, crop);
            insertStmt.executeUpdate();
            System.out.println("Added new crop to database: " + crop);
            insertStmt.close();
        }

        checkStmt.close();
        rs.close();
    }
}
