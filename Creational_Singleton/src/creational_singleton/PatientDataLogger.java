package creational_singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDataLogger {
   public void logToDatabase(String patientID, String record) {
        try {
            Connection connection = MedicalDatabaseConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO patient_records (patient_id, record) VALUES (?, ?)");
            stmt.setString(1, patientID);
            stmt.setString(2, record);
            stmt.executeUpdate();
            System.out.println("Patient record logged successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
}
