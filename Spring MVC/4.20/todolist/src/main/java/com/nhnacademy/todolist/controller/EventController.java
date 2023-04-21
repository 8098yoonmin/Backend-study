package com.nhnacademy.todolist.controller;

import com.nhnacademy.todolist.domain.Event;
import com.nhnacademy.todolist.repository.MemoryRepository;
import com.nhnacademy.todolist.request.EventRequest;

import com.sun.net.httpserver.Headers;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class EventController {

    private final MemoryRepository memoryRepository;

    public EventController(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    @PostMapping("/calendar/events")
    public Event createEvent(@RequestHeader("X-USER-ID")String id, @RequestBody EventRequest eventRequest) {

        Event event = new Event(eventRequest.getSubject(), eventRequest.getEventAt());
        memoryRepository.save( id, event);
        return event;
    }

}
