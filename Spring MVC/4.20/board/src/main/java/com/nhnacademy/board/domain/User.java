package com.nhnacademy.board.domain;

public class User {

    private String userId;

    private String userName;

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

    public User(String userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public void update(String userId, String userName, String password) {
        this.userId = userId;
        this.userName=userName;
        this.userPassword = password;
    }
}
