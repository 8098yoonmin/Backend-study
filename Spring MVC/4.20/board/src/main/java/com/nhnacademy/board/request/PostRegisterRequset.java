package com.nhnacademy.board.request;

import javax.validation.constraints.NotBlank;

public class PostRegisterRequset {

    @NotBlank(message="제목을 입력해주세요.")
    private String title;

    @NotBlank(message="내용을 입력해주세요")
    private String content;


}
