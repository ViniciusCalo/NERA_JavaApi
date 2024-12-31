package app.nera.JavaAPI.neraAPI.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClassroomStudentPK implements Serializable {

    private Integer classroomid;
    private Integer studentid;

    public ClassroomStudentPK() {}

    public ClassroomStudentPK(Integer classroomid, Integer studentid) {
        this.classroomid = classroomid;
        this.studentid = studentid;
    }

    public Integer getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(Integer classroomid) {
        this.classroomid = classroomid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassroomStudentPK that = (ClassroomStudentPK) o;
        return Objects.equals(classroomid, that.classroomid) && Objects.equals(studentid, that.studentid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classroomid, studentid);
    }
}
