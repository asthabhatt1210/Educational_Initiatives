package creational_factory;
import java.sql.SQLException;
import java.util.Scanner;
public class Creational_Factory {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for task type and crop
        System.out.println("Enter Task Type (water/fertilize/harvest):");
        String taskType = scanner.nextLine();

        System.out.println("Enter Crop Name:");
        String crop = scanner.nextLine();

        // Generating appropriate task executor
        try {
            CropTaskExecutor taskExecutor = CropTaskFactory.getTaskExecutor(taskType);
            taskExecutor.executeTask(crop);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  
        }

        scanner.close();
    }
}
