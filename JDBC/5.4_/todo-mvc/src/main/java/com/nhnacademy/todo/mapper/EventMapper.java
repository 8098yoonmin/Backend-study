package com.nhnacademy.todo.mapper;

import com.nhnacademy.todo.domain.Event;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventMapper {

    void save(Event event);

    //수정
    //삭제
    //조회

}
