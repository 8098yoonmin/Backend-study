package com.nhnacademy.todolist.repository;


import com.nhnacademy.todolist.domain.Event;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class MemoryRepository {
    private final ConcurrentMap<String, Event> eventMap = new ConcurrentHashMap<>();




    public void save(String id, Event event) {
        eventMap.put(id, event);
    }


}
