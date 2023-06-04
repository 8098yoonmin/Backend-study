package com.nhnacademy.board_remind.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class Posts {
    private Long id;
    private String title;
    private String content;
    private String writerUserId;
    private int viewCount;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date writeTime;

    public Posts(Long id, String title, String content,String writerUserId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writerUserId = writerUserId;
        writeTime = new Date();
        this.viewCount = 0;
    }
    public Posts(){}

    public void increaseViewCount() {
        viewCount++;
    }

}
