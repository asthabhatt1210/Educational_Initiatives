
package virtual_classroom.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import virtual_classroom.database.DatabaseConnection;
import virtual_classroom.model.Classroom;

public class ClassroomService {
   public void addClassroom(String name) {
        String query = "INSERT INTO classrooms (name) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Classroom " + name + " has been created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Classroom> listClassrooms() {
        List<Classroom> classrooms = new ArrayList<>();
        String query = "SELECT * FROM classrooms";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                classrooms.add(new Classroom(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classrooms;
    }

    public void removeClassroom(int id) {
        String query = "DELETE FROM classrooms WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Classroom with ID " + id + " has been removed.");
            } else {
                System.out.println("Classroom with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
