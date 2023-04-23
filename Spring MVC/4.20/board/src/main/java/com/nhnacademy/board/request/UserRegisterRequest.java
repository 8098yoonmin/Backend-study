package com.nhnacademy.board.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class UserRegisterRequest {

    @NotBlank(message ="아이디를 입력해주세요")
    @Length(min=5, max=20, message="아이디는 최소 5자이상 20자 이하입니다.")
    private String userId;

    @NotBlank(message="이름을 입력해주세요")
    private String userName;



    @NotBlank(message="비밀번호를 입력해주세요")
    @Length(min=5, max=20, message="비밀번호는 최소 5자이상 20자 이하입니다.")
    private String userPassword;


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public String toString() {
        return "StudentRegisterRequest{" +
                "id='" + userId + '\'' +
                ", name='" + userName + '\'' +
                ", password=" + userPassword +
                '}';
    }
}
