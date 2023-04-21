package com.nhnacademy.todolist.domain;

import java.util.List;
public class Event {

    //X-USER-ID
    private String id;
    private String subject;

    private String eventAt;

    public Event(String subject, String eventAt) {
        this.subject = subject;
        this.eventAt = eventAt;
    }

    public void setEventAt(String eventAt) {
        this.eventAt = eventAt;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public String getEventAt() {
        return eventAt;
    }
}
