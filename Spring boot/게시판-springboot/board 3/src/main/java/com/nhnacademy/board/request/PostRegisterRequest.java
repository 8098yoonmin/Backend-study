package com.nhnacademy.board.request;

import lombok.Data;

import javax.validation.Valid;

@Valid
@Data
public class PostRegisterRequest {

    private String title;
    private String content;


}
