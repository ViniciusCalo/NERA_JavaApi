package app.nera.JavaAPI.neraAPI.dto;

public class LoginResponse {

    private String token;
    private String username;
    private String profilePicture;

    public LoginResponse(String token, String username, String profilePicture) {
        this.token = token;
        this.username = username;
        this.profilePicture = profilePicture;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
