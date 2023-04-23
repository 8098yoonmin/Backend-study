package com.nhnacademy.board.domain;

public class User {

    private String userId;

    private String userName;

    private String profileName;

    private String userPassword;

    public String getUserId(){
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
    public String getProfileName() {
        return profileName;
    }


    public User(String userId, String userName, String profileName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.profileName = profileName;
        this.userPassword = userPassword;
    }

    public User() {}

    public void update(String userId, String userName, String profileName, String password) {
        this.userId = userId;
        this.userName=userName;
        this.profileName = profileName;
        this.userPassword = password;
    }
}
