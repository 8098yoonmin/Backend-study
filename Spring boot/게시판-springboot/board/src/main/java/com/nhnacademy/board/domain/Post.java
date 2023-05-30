package com.nhnacademy.board.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Table(name="posts")
@EqualsAndHashCode
@ToString
@Setter
public class Post {
    @Id
    private Long id;
    private String title;
    private String content;
    private String writerUserId;
    private int viewCount;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date writeTime;

    public Post(Long id, String title, String content,String writerUserId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writerUserId = writerUserId;
        writeTime = new Date();
        this.viewCount = 0;
    }
    public Post(){}

}
