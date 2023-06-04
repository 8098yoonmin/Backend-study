package com.nhnacademy.board_remind.exception;

public class ExistUserException extends RuntimeException {
    public ExistUserException(String id){ super("아이디 중복: "+id);}
}
