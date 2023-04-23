package com.nhnacademy.board.domain;

public class User {

    private String userId;

    private String userName;

    private String userImage;

    public String getUserImage() {
        return userImage;
    }

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

    public User(String userId, String userName, String userImage,String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userImage = userImage;
        this.userPassword = userPassword;
    }

    public User() {}

    public void update(String userId, String userName, String userImage, String password) {
        this.userId = userId;
        this.userName=userName;
        this.userImage= userImage;
        this.userPassword = password;
    }
}
