package app.nera.JavaAPI.neraAPI.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ClassroomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classroomid;
    @Column(unique = true, nullable = false)
    private String classroomname;
    @Column(unique = true, nullable = false)
    private String classroomdescription;
    @Column(unique = true, nullable = false)
    private LocalDateTime classroomcreation;
    @Column(unique = true, nullable = false)
    private String tokenclass;
    @OneToOne
    @JoinColumn(name="teacherid", referencedColumnName = "teacherid", unique = true, nullable = false)
    private TeacherModel teacherid;
    @OneToOne
    @JoinColumn(name="studentid", referencedColumnName = "studentid", unique = true, nullable = false)
    private StudentModel studentid;
}
