package com.nhnacademy.board.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="user_id")
    private String userId;
    private String password;
    private String name;
    private String profileFileName;

    public User(String userId, String password, String name, String profileFileName) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.profileFileName = profileFileName;
    }

    public User() {
    }
}

