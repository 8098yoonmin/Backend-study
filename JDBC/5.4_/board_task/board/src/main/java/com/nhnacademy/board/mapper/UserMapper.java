package com.nhnacademy.board.mapper;

import com.nhnacademy.board.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DbMapper {

    //등록
    void register(User user);

    //유저조회
    List<User> getAllUsers();

}
