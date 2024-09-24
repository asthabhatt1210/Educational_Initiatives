
package behavioural_observer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeLogService implements Observer{

    @Override
    public void update(String event) {
        logEventToDatabase(event);
    }

    private void logEventToDatabase(String event) {
        
         try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO employee_logs (event_type) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, event);
            statement.executeUpdate();
            System.out.println("Employee log saved to the database: " + event);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
