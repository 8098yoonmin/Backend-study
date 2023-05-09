package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Enrollment;
import com.nhnacademy.springjpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// TODO #5: Enrollment Entity에 대한 Repository interface
//          Enrollment Entity 맵핑 내용에 따라 interface 를 수정하세요.
public interface EnrollmentRepository extends JpaRepository<Enrollment, Enrollment.Pk> {
    // TODO #6: 학생 이름으로 수강신청 목록을 가져오는 쿼리가 실행되도록 메서드 이름을 정의하세요.
    List<Enrollment> findByStudent_Name(String studentName);

    // TODO #7: 강의 이름으로 수강신청 목록을 가져오는 쿼리가 실행되도록 메서드 이름을 정의하세요.
    List<Enrollment> findByClazz_Name(String clazzName);

}
