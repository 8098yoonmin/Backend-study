package com.nhnacademy.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO #3: `Classes` 테이블과 맵핑될 `Clazz` Entity 클래스
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Classes")
public class Clazz {
    @Id
    @Column(name = "class_id")
    private Long id;

    @Column(name = "class_name")
    private String name;

}
