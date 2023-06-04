package com.nhnacademy.board_remind.request;

import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@ToString
@Valid
@Getter
public class UserRegisterRequest {
    private String id;
    private String password;
    private String name;
    private MultipartFile profileFileName;

}
