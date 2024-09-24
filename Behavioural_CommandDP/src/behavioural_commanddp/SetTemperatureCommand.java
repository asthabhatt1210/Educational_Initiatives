
package behavioural_commanddp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SetTemperatureCommand implements Command {
   private int temperature;

    public SetTemperatureCommand(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        System.out.println("Setting the thermostat to " + temperature + " degrees.");
        logCommandToDatabase("Set Temperature to " + temperature);
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
