package com.nhnacademy.board_remind.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@ToString
@Valid
@Setter
@Data
public class UserRegisterRequest {
    private String id;
    private String password;
    private String name;

    private MultipartFile profileFileName;

}
