package app.nera.JavaAPI.neraAPI.model;

import jakarta.persistence.*;

@Entity
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentid;
    @OneToOne
    @JoinColumn(name="userid", referencedColumnName = "userid", unique = true, nullable = false)
    private UserModel userid;

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
}
