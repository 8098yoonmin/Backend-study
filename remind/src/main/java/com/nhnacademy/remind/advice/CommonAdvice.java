package com.nhnacademy.remind.advice;

import com.nhnacademy.remind.exception.NotFoundResidentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
public class CommonAdvice {

    @InitBinder
    void initBinder(WebDataBinder binder) { binder.initDirectFieldAccess();}

    @ExceptionHandler(NotFoundResidentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundResidentException(NotFoundResidentException notFoundResidentException) {
        log.info("error:{}", notFoundResidentException.getMessage(), notFoundResidentException);
        return "error/error";
    }

}
