package app.nera.JavaAPI.neraAPI.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentAchievementPK implements Serializable {
    private Integer studentId;
    private Integer achievementid;

    public StudentAchievementPK() {}

    public StudentAchievementPK(Integer studentId, Integer achievementid){
        this.studentId = studentId;
        this.achievementid = achievementid;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getAchievementid() {
        return achievementid;
    }

    public void setAchievementid(Integer achievementid) {
        this.achievementid = achievementid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAchievementPK that = (StudentAchievementPK) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(achievementid, that.achievementid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, achievementid);
    }
}
