package com.nhnacademy.board.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Valid
public class UserRegisterRequest {

    @NotBlank(message ="아이디를 입력해주세요")
    @Length(min=5, max=20, message="아이디는 최소 5자이상 20자 이하입니다.")
    private String userId;

    @NotBlank(message="이름을 입력해주세요")
    private String userName;

    private MultipartFile profileName;

    @NotBlank(message="비밀번호를 입력해주세요")
    @Length(min=5, max=20, message="비밀번호는 최소 5자이상 20자 이하입니다.")
    private String userPassword;



    @Override
    public String toString() {
        return "userRegisterRequest{" +
                "id='" + userId + '\'' +
                ", name='" + userName + '\'' +
                ", password=" + userPassword +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public MultipartFile getProfileName() {
        return profileName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setProfileName(MultipartFile profileName) {
        this.profileName = profileName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
