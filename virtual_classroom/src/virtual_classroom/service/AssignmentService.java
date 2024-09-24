
package virtual_classroom.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import virtual_classroom.database.DatabaseConnection;

public class AssignmentService {
   public void scheduleAssignment(String classroomName, String details) {
        String query = "INSERT INTO assignments (classroom_id, details) VALUES ((SELECT id FROM classrooms WHERE name = ?), ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, classroomName);
            pstmt.setString(2, details);
            pstmt.executeUpdate();
            System.out.println("Assignment for " + classroomName + " has been scheduled.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void submitAssignment(String studentId, String classroomName, String details) {
        String query = "INSERT INTO submissions (student_id, classroom_id, assignment_details) VALUES (?, (SELECT id FROM classrooms WHERE name = ?), ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, studentId);
            pstmt.setString(2, classroomName);
            pstmt.setString(3, details);
            pstmt.executeUpdate();
            System.out.println("Assignment submitted by Student " + studentId + " in " + classroomName + ".");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void listSubmissions(String classroomName) {
        String query = "SELECT s.student_id, a.details FROM submissions s " +
                       "JOIN assignments a ON s.assignment_details = a.details " +
                       "JOIN classrooms c ON s.classroom_id = c.id WHERE c.name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, classroomName);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Submissions for " + classroomName + ":");
            while (rs.next()) {
                String studentId = rs.getString("student_id");
                String assignmentDetails = rs.getString("details");
                System.out.println("Student ID: " + studentId + ", Assignment: " + assignmentDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
