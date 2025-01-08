package app.nera.JavaAPI.neraAPI.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class TeacherModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherid;

    @OneToOne
    @JoinColumn(name="userid", referencedColumnName = "userid", unique = true, nullable = false)
    private UserModel userid;
    @Column(unique = true, nullable = false)
    private String teachercpf;

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public UserModel getUserid() {
        return userid;
    }

    public void setUserid(UserModel userid) {
        this.userid = userid;
    }

    public String getTeachercpf() {
        return teachercpf;
    }

    public void setTeachercpf(String teachercpf) {
        this.teachercpf = teachercpf;
    }

    public TeacherModel(Integer teacherid, UserModel userid, String teachercpf) {
        this.teacherid = teacherid;
        this.userid = userid;
        this.teachercpf = teachercpf;
    }

    public TeacherModel(UserModel userid, String teachercpf) {
        this.userid = userid;
        this.teachercpf = teachercpf;
    }

    public TeacherModel(){}

    @Override
    public String toString() {
        return "TeacherModel{" +
                "teacherid=" + teacherid +
                ", userid=" + userid +
                ", teachercpf='" + teachercpf + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherModel that = (TeacherModel) o;
        return Objects.equals(teacherid, that.teacherid) && Objects.equals(userid, that.userid) && Objects.equals(teachercpf, that.teachercpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherid, userid, teachercpf);
    }
}
