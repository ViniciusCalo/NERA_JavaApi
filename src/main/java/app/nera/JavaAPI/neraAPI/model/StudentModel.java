package app.nera.JavaAPI.neraAPI.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentid;
    @OneToOne
    @JoinColumn(name="userid", referencedColumnName = "userid", unique = true, nullable = false)
    private UserModel userid;

    public StudentModel(Integer studentid, UserModel userid) {
        this.studentid = studentid;
        this.userid = userid;
    }

    public StudentModel(UserModel userid) {
        this.userid = userid;
    }

    public StudentModel() {}


    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public UserModel getUserid() {
        return userid;
    }

    public void setUserid(UserModel userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "studentid=" + studentid +
                ", userid=" + userid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentModel that = (StudentModel) o;
        return Objects.equals(studentid, that.studentid) && Objects.equals(userid, that.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentid, userid);
    }
}
