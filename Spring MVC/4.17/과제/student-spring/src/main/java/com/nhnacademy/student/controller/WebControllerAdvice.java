package com.nhnacademy.student.controller;

import com.nhnacademy.student.exception.IdExistException;
import com.nhnacademy.student.exception.StudentNotFoundException;
import com.nhnacademy.student.exception.ValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class WebControllerAdvice {
    @ExceptionHandler(value = StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String studentNotFound() {
        return "studentNotFound";
    }

    @ExceptionHandler(value = IdExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String idExist() {
        return "idExist";
    }

    @ExceptionHandler(value = ValidException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String validException() {
        return "validError";
    }

    @InitBinder
    void initBinder(WebDataBinder binder){
        binder.initDirectFieldAccess();
    }

}
