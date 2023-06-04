package com.nhnacademy.board_remind.advice;

import com.nhnacademy.board_remind.exception.ExistUserException;
import com.nhnacademy.board_remind.exception.NoWriter;
import com.nhnacademy.board_remind.exception.NotFoundStudentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class ExceptionsHandler {
    @InitBinder
    void initBinder(WebDataBinder binder){
        binder.initDirectFieldAccess();
    }

    @ExceptionHandler(NotFoundStudentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String studentNotFound(NotFoundStudentException notFoundStudentException){
        log.info("error:{}", notFoundStudentException.getMessage(),notFoundStudentException);
        return "error/notFoundStudent";
    }

    @ExceptionHandler(ExistUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String existUserId(ExistUserException exception){
        return "error/existError";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String pageNotFound(){
        log.info("404 not found");
        return "error/404";
    }

    @ExceptionHandler(NoWriter.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String Writer(){
        return "error/noWriter";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String internalServerError(Exception e, Model model){
        model.addAttribute("exception", e.getMessage());
        log.info("internal server error");
        return "error/500";
    }


}
