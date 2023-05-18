package com.nhnacademy.security.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="Members")
@AllArgsConstructor
public class Member {
    @Id
    @Column(name="member_id")
    private String id;

    private String name;

    private String pwd;

}
