package app.nera.JavaAPI.neraAPI.model;

import jakarta.persistence.*;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    @Column(nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String useremail;
    @Column(nullable = false)
    private String userpassword;
    @Column(nullable = true)
    private String profilepicture;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public Integer getUserid() {
        return userid;

    }

    public void setUserid(Integer userid) {
        this.userid = userid;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
