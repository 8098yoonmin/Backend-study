package com.nhnacademy.board_remind.request;

import lombok.Getter;

import javax.validation.Valid;

@Valid
@Getter
public class PostRegisterRequest {
    private String title;
    private String content;
}
