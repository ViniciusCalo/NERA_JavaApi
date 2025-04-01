package app.nera.JavaAPI.neraAPI.dto;

import app.nera.JavaAPI.neraAPI.model.UserModel;

public class RegistrationResponse {
    private final String message;
    private final UserModel user;
    private final Object data;

    public RegistrationResponse(String message, UserModel user, Object data) {
        this.message = message;
        this.user = user;
        this.data = data;
    }

    public String getMessage() {return message;}
    public UserModel getUser() {return user;}
    public Object getData() {return data;}
}