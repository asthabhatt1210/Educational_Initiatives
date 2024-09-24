package virtual_classroom;
import java.util.Scanner;
import virtual_classroom.service.AssignmentService;
import virtual_classroom.service.ClassroomService;
import virtual_classroom.service.StudentService;

public class Virtual_classroom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClassroomService classroomService = new ClassroomService();
        StudentService studentService = new StudentService();
        AssignmentService assignmentService = new AssignmentService();

        while (true) {
            System.out.println("Enter command:");
            String input = scanner.nextLine();
            String[] parts = input.split(" ", 2);

            if (parts.length == 0) {
                System.out.println("Invalid command.");
                continue;
            }

            switch (parts[0]) {
                case "add_classroom":
                    if (parts.length < 2) {
                        System.out.println("Please provide a classroom name.");
                    } else {
                        classroomService.addClassroom(parts[1]);
                    }
                    break;

                case "add_student":
                    if (parts.length < 2 || !parts[1].contains(" ")) {
                        System.out.println("Invalid command. Please provide student ID and classroom name.");
                    } else {
                        String[] studentParts = parts[1].split(" ", 2);
                        studentService.addStudent(studentParts[0], studentParts[1]);
                    }
                    break;

                case "schedule_assignment":
                    if (parts.length < 2 || !parts[1].contains(" ")) {
                        System.out.println("Invalid command. Please provide classroom name and assignment details.");
                    } else {
                        String[] assignmentParts = parts[1].split(" ", 2);
                        assignmentService.scheduleAssignment(assignmentParts[0], assignmentParts[1]);
                    }
                    break;

                case "submit_assignment":
                    if (parts.length < 2 || !parts[1].contains(" ")) {
                        System.out.println("Invalid command. Please provide student ID, classroom name, and assignment details.");
                    } else {
                        String[] submissionParts = parts[1].split(" ", 3);
                        assignmentService.submitAssignment(submissionParts[0], submissionParts[1], submissionParts[2]);
                    }
                    break;

                case "exit":
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}