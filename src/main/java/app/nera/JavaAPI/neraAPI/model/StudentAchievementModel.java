package app.nera.JavaAPI.neraAPI.model;

import jakarta.persistence.*;

@Entity
public class StudentAchievementModel {

    @EmbeddedId
    private StudentAchievementPK id;

    @ManyToOne
    @MapsId("studentid")
    @JoinColumn(name = "studentid")
    private StudentModel studentid;

    @ManyToOne
    @MapsId("achievementid")
    @JoinColumn(name = "achievementid")
    private AchievementModel achievementid;

    public StudentAchievementModel() {}

    public StudentAchievementPK getId() {
        return id;
    }

    public void setId(StudentAchievementPK id) {
        this.id = id;
    }

    public StudentModel getStudentid() {
        return studentid;
    }

    public void setStudentid(StudentModel studentid) {
        this.studentid = studentid;
    }

    public AchievementModel getAchievementid() {
        return achievementid;
    }

    public void setAchievementid(AchievementModel achievementid) {
        this.achievementid = achievementid;
    }
}
