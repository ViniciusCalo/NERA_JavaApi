package app.nera.JavaAPI.neraAPI.model;

import jakarta.persistence.*;

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
}
