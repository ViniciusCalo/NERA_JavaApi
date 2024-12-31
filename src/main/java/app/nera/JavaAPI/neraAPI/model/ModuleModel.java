package app.nera.JavaAPI.neraAPI.model;

import jakarta.persistence.*;

@Entity
public class ModuleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moduleid;

    private String modulename;

    private String moduledescription;

    @ManyToOne
    @JoinColumn(name="trackid", referencedColumnName = "trackid", unique = true, nullable = false)
    private TrackModel trackid;

    public Integer getModuleid() {
        return moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    public String getModuledescription() {
        return moduledescription;
    }

    public void setModuledescription(String moduledescription) {
        this.moduledescription = moduledescription;
    }

    public TrackModel getTrackid() {
        return trackid;
    }

    public void setTrackid(TrackModel trackid) {
        this.trackid = trackid;
    }
}
