package com.nhnacademy.todolist.request;

public class EventRequest {

    private String subject;

    private String eventAt;

    public EventRequest(String subject, String eventAt) {
        this.subject = subject;
        this.eventAt = eventAt;
    }

    public EventRequest() {}

    public String getSubject() {
        return subject;
    }

    public String getEventAt() {
        return eventAt;
    }
}
