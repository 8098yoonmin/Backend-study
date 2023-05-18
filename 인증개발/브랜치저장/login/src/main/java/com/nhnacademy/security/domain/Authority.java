package com.nhnacademy.security.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="Authorities")
public class Authority {

    @Id
    @Column(name="member_id")
    private String memberId;

    private String authority;


}
