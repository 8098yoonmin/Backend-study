package com.nhnacademy.springjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

// TODO #4: `Enrollments` 테이블과 맵핑될 `Enrollment` Entity 클래스
//          Entity 맵핑과 연관관계 맵핑을 하세요.
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Enrollments")
public class Enrollment {

    @EmbeddedId
    private Pk pk;

    @Column(name="enrolled_at")
    private LocalDateTime enrolledAt;

    @MapsId("studentId")
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @MapsId("classId")
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Clazz clazz;

    @NoArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "class_id")
        private Long classId;

        @Column(name = "student_id")
        private Long studentId;
    }


}
