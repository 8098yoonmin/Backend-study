package com.nhnacademy.board_remind.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Users {
    private String id;
    private String password;
    private String name;
    private String profileFileName;

    public Users(String id, String password, String name, String profileFileName) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.profileFileName = profileFileName;
    }

    public Users(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

}
