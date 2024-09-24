package behavioural_commanddp;

public class Behavioural_CommandDP {

   public static void main(String[] args) {
       
        SmartHomeInvoker smartHome = new SmartHomeInvoker();

        // Set temperature command
        Command setTemperature = new SetTemperatureCommand(22);
        smartHome.setCommand(setTemperature);
        smartHome.executeCommand();

        // Lock door command
        Command lockDoor = new LockDoorCommand(true);
        smartHome.setCommand(lockDoor);
        smartHome.executeCommand();

        // Unlock door command
        Command unlockDoor = new LockDoorCommand(false);
        smartHome.setCommand(unlockDoor);
        smartHome.executeCommand();
    }  
}
