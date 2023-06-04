package com.nhnacademy.board_remind.request;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;

@Slf4j
@Data
@Getter
public class LoginRequest {

    @NotBlank(message ="UserId is empty!")
    private String userId;

    @NotBlank(message ="UserPassword is empty!")
    private String userPassword;

}
