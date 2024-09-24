
package behavioural_commanddp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LockDoorCommand implements Command{
   private boolean lock;

    public LockDoorCommand(boolean lock) {
        this.lock = lock;
    }

    @Override
    public void execute() {
        if (lock) {
            System.out.println("Locking the door.");
            logCommandToDatabase("Lock Door");
        } else {
            System.out.println("Unlocking the door.");
            logCommandToDatabase("Unlock Door");
        }
    }

    private void logCommandToDatabase(String commandName) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO command_logs (command_name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, commandName);
            statement.executeUpdate();
            System.out.println("Command log saved: " + commandName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
