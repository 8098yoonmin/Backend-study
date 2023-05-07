package com.nhnacademy.board.request;

import javax.validation.constraints.NotBlank;

public class PostRegisterRequset {

    @NotBlank(message="제목을 입력해주세요.")
    private String title;


    @NotBlank(message="내용을 입력해주세요")
    private String content;


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
