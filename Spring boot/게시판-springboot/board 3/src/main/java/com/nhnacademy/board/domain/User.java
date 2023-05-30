package com.nhnacademy.board.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Table(name="Users")
@Entity
@EqualsAndHashCode
@Getter @Setter
public class User {

    @Id
    @Column(name = "user_id")
    private String userId;
    private String password;
    private String name;
    private String profileFileName;


    public User(String id, String password, String name, String fileName) {
    }
}
