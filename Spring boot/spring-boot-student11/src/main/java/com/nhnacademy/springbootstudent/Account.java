package com.nhnacademy.springbootstudent;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name="account")
public class Account {


    @Id
    private Long id;
    private String number;
    private Integer balance;

    public Account() {
    }

    public Account(Long id, String number, Integer balance) {
        this.id = id;
        this.number = number;
        this.balance = balance;
    }
}
