
package virtual_classroom.model;

public class Assignment {
    private int classroomId;
    private String details;

    public Assignment() {}

    public Assignment(int classroomId, String details) {
        this.classroomId = classroomId;
        this.details = details;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
