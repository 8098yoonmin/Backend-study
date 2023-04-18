package com.nhnacademy.student.advice;

import com.nhnacademy.student.exception.DuplicateException;
import com.nhnacademy.student.exception.PostNotFoundException;
import com.nhnacademy.student.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CommonControllerAdvice {


    @InitBinder
    void initBinder(WebDataBinder binder){
        binder.initDirectFieldAccess();
    }

    @ExceptionHandler(value= {PostNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String postNotFound() {
        return "post_404";
    }

    @ExceptionHandler(value={DuplicateException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String idExiest(){
        return "existError";
    }

    @ExceptionHandler(value={ValidationException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String validError(){
        return "validError";
    }

}
