
package behavioural_commanddp;

public class SmartHomeInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command to execute.");
        }
    }
}
