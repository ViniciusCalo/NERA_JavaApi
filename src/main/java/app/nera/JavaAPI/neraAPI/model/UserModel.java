package app.nera.JavaAPI.neraAPI.model;

import jakarta.persistence.*;

import java.util.Objects;

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

    public UserModel(String username, String useremail, String userpassword, String profilepicture, Role role) {
        this.username = username;
        this.useremail = useremail;
        this.userpassword = userpassword;
        this.profilepicture = profilepicture;
        this.role = role;
    }

    public UserModel(Integer userid, String username, String useremail, String userpassword, String profilepicture, Role role) {
        this.userid = userid;
        this.username = username;
        this.useremail = useremail;
        this.userpassword = userpassword;
        this.profilepicture = profilepicture;
        this.role = role;
    }

    public UserModel(){}

    @Override
    public String toString () {

        return "UserModel{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", useremail='" + useremail + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return userid != null ? userid.equals(userModel.userid) : userModel.userid == null;
    }

    @Override
    public int hashCode() {
        return userid != null ? userid.hashCode() : 0;
    }
}
