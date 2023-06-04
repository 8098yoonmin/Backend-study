package com.nhnacademy.board_remind.exception;

import java.rmi.StubNotFoundException;

public class NotFoundStudentException extends  RuntimeException{
    public NotFoundStudentException(String message){ super(message);}
}
