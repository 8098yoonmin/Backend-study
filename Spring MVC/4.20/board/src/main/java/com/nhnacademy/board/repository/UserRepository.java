package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.Student;
import com.nhnacademy.board.domain.User;

import java.util.List;

public interface UserRepository {
    //학생-등록
    void save(User user);
    //학생-수정
    void update(User user);

    //학생-삭제
    void deleteById(String id);

    //학생-조회_by id
    User getUserById(String id);

    //학생-리스트
    List<User> getUsers();

    //학생-아이디 존재여부
    boolean existById(String id);
}
