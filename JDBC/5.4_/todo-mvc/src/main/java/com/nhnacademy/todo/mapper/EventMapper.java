package com.nhnacademy.todo.mapper;

import com.nhnacademy.todo.domain.Event;
import com.nhnacademy.todo.dto.EventDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EventMapper {

    //저장
    void save(Event event);

    //수정
    void modify(@Param("eventId")long eventId, @Param("event")EventDto event);

    //삭제
    void deleteOne(long eventId);

    //삭제
    void deleteByDaily(LocalDate eventAt);

    //조회
    EventDto getEvent(long eventId);

    //월별조회
    List<EventDto> getEventsByMonth(@Param("year")int year, @Param("month")int month);

    //일별조회
    List<EventDto> getEventsByDaily(@Param("year")int year, @Param("month")int month, @Param("day")int day);

    //일일등록 카운트
    long countDailyRegister(LocalDate targetDate);



}
