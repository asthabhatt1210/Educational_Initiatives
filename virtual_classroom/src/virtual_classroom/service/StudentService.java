
package virtual_classroom.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import virtual_classroom.database.DatabaseConnection;
import virtual_classroom.model.Student;

public class StudentService {
   public void addStudent(String studentId, String classroomName) {
    // Check if the student ID already exists in the database
    String checkQuery = "SELECT COUNT(*) FROM students WHERE student_id = ?";
    String insertQuery = "INSERT INTO students (student_id, classroom_id) VALUES (?, (SELECT id FROM classrooms WHERE name = ?))";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {

        checkStmt.setString(1, studentId);
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            System.out.println("Student ID " + studentId + " already exists. Please choose a different ID.");
            return;
        }

        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
            insertStmt.setString(1, studentId);
            insertStmt.setString(2, classroomName);
            insertStmt.executeUpdate();
            System.out.println("Student " + studentId + " has been enrolled in " + classroomName + ".");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public List<Student> listStudentsByClassroom(String classroomName) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT s.student_id, s.classroom_id FROM students s " +
                       "JOIN classrooms c ON s.classroom_id = c.id WHERE c.name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, classroomName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String studentId = rs.getString("student_id");
                int classroomId = rs.getInt("classroom_id");
                students.add(new Student(studentId, classroomId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void removeStudent(String studentId) {
        String query = "DELETE FROM students WHERE student_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, studentId);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Student " + studentId + " has been removed.");
            } else {
                System.out.println("Student " + studentId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
