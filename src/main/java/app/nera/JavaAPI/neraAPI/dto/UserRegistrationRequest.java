package app.nera.JavaAPI.neraAPI.dto;

import app.nera.JavaAPI.neraAPI.model.Role;

public class UserRegistrationRequest {

    private String username;
    private String useremail;
    private String userpassword;
    private Role role;
    private String teacherCpf;

    private String profilePicture;

    //Getters and Setters
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getUseremail() {return useremail;}
    public void setUseremail(String useremail) {this.useremail = useremail;}
    public String getUserpassword() {return userpassword;}
    public void setUserpassword(String userpassword) {this.userpassword = userpassword;}
    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}
    public String getTeacherCpf() {return teacherCpf;}
    public void setTeacherCpf(String teacherCpf) {this.teacherCpf = teacherCpf;}

    public String getProfilePicture(){return profilePicture;}
    public void setProfilePicture(String profilePicture) {this.profilePicture = profilePicture;}

}
