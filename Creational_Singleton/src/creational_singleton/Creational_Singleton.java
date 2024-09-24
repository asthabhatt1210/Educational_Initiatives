
package creational_singleton;
import java.util.Scanner;

public class Creational_Singleton {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientDataLogger logger = new PatientDataLogger();

        // Taking user input for patient details
        System.out.println("Enter Patient ID:");
        String patientID = scanner.nextLine();

        System.out.println("Enter Patient Record:");
        String record = scanner.nextLine();

        // Logging to the database
        logger.logToDatabase(patientID, record);

        scanner.close();
    }
}
