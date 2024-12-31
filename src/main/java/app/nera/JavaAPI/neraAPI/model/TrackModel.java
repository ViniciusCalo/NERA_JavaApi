package app.nera.JavaAPI.neraAPI.model;

import jakarta.persistence.*;

@Entity
public class TrackModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trackid;
    @Column(unique = true, nullable = false)
    private String trackname;
    @Column(unique = true)
    private String trackdescription;

    public Integer getTrackid() {
        return trackid;
    }

    public void setTrackid(Integer trackid) {
        this.trackid = trackid;
    }

    public String getTrackname() {
        return trackname;
    }

    public void setTrackname(String trackname) {
        this.trackname = trackname;
    }

    public String getTrackdescription() {
        return trackdescription;
    }

    public void setTrackdescription(String trackdescription) {
        this.trackdescription = trackdescription;
    }
}
