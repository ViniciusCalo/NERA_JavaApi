package app.nera.JavaAPI.neraAPI.model;

import jakarta.persistence.*;

@Entity
public class ClassroomStudentModel {

    @EmbeddedId
    private ClassroomStudentPK id;

    @ManyToOne
    @MapsId("classroomid")
    @JoinColumn(name = "classroomid")
    private ClassroomModel classroomid;
    @ManyToOne
    @MapsId("studentid")
    @JoinColumn(name = "studentid")
    private StudentModel studentid;

    public ClassroomStudentModel() {}

    public ClassroomStudentPK getId() {
        return id;
    }

    public void setId(ClassroomStudentPK id) {
        this.id = id;
    }

    public ClassroomModel getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(ClassroomModel classroomid) {
        this.classroomid = classroomid;
    }

    public StudentModel getStudentid() {
        return studentid;
    }

    public void setStudentid(StudentModel studentid) {
        this.studentid = studentid;
    }
}
