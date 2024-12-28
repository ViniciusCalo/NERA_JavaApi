package app.nera.JavaAPI.neraAPI.model;

import jakarta.persistence.*;

@Entity
public class AchievementModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer achievementid;
    @Column(unique = true, nullable = false)
    private String achievementname;
    @Column(unique = true, nullable = false)
    private String achievementdescription;
    @Column(unique = true, nullable = false)
    private String criteria;
    @Column(unique = true, nullable = false)
    private String imageurl;

    public Integer getAchievementid() {
        return achievementid;
    }

    public void setAchievementid(Integer achievementid) {
        this.achievementid = achievementid;
    }

    public String getAchievementname() {
        return achievementname;
    }

    public void setAchievementname(String achievementname) {
        this.achievementname = achievementname;
    }

    public String getAchievementdescription() {
        return achievementdescription;
    }

    public void setAchievementdescription(String achievementdescription) {
        this.achievementdescription = achievementdescription;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
