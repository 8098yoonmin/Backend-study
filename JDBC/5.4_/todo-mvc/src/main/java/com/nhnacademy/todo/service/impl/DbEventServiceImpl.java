package com.nhnacademy.todo.service.impl;

import com.nhnacademy.todo.domain.Event;
import com.nhnacademy.todo.dto.DailyRegisterCountResponseDto;
import com.nhnacademy.todo.dto.EventCreatedResponseDto;
import com.nhnacademy.todo.dto.EventDto;
import com.nhnacademy.todo.exception.EventNotFoundException;
import com.nhnacademy.todo.mapper.EventMapper;
import com.nhnacademy.todo.service.EventService;
import com.nhnacademy.todo.share.UserIdStore;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//여기 service가 mybatis에서 이용하는 파일인듯?
@Primary
@Service
@RequiredArgsConstructor
@Transactional // (rollbackFor = {EventNotFoundException.class})
public class DbEventServiceImpl implements EventService {
    private final EventMapper eventMapper;
    @Override
    public EventCreatedResponseDto insert(EventDto eventDto) {
        Event event = new Event(UserIdStore.getUserId(), eventDto.getSubject(), eventDto.getEventAt());
        eventMapper.save(event);
//        throw new RuntimeException();
        return new EventCreatedResponseDto(event.getId());
    }

    //eventmapper와 동일한 파라미터?
    @Override
    public long update(long eventId, EventDto eventDto) {
//        Event target = new Event(UserIdStore.getUserId(), eventDto.getSubject(), eventDto.getEventAt());
//        target.setId(eventId);
        eventMapper.modify(eventId,eventDto);
        return eventId;
    }

    @Override
    public void deleteOne(long eventId) {
        eventMapper.deleteOne(eventId);
    }

    @Override
    public EventDto getEvent(long eventId) {
        EventDto event = eventMapper.getEvent(eventId);
        return new EventDto(event.getId(), event.getSubject(),event.getEventAt());
    }

    @Override
    public List<EventDto> getEventListByMonthly(Integer year, Integer month) {
        List<EventDto> eventList = eventMapper.getEventsByMonth(year, month);
        return eventList;
    }


    @Override
    public List<EventDto> getEventListBydaily(Integer year, Integer month, Integer day) {
        List<EventDto> eventList = eventMapper.getEventsByDaily(year, month, day);
        return eventList;
    }

    @Override
    public DailyRegisterCountResponseDto getDayliyRegisterCount(LocalDate targetDate) {
        long count = eventMapper.countDailyRegister( targetDate);
        return new DailyRegisterCountResponseDto(count);
    }


    @Override
    public void deleteEventByDaily(LocalDate eventAt) {
        eventMapper.deleteByDaily(eventAt);
    }

    @Override
    public boolean checkOwner(String dbUserId) {
        return EventService.super.checkOwner(dbUserId);
    }
}
