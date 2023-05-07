package com.nhnacademy.board.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "userId is empty")
    private String userId;

    @NotBlank(message ="userPassword  is empty!")
    private String userPassword;

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
