
package virtual_classroom.model;

public class Student {
    private String studentId;
    private int classroomId;

    public Student() {}

    public Student(String studentId, int classroomId) {
        this.studentId = studentId;
        this.classroomId = classroomId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }
}