package com.example.post.controller;

import com.example.post.exception.CategoryNotFoundException;
import com.example.post.exception.NoLoverException;
import com.example.post.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler(UserNotFoundException.class)
    public String handlerExistingUserException(UserNotFoundException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public String handlerCategoryNotFoundException(CategoryNotFoundException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(NoLoverException.class)
    public String handlerNoLoverException(NoLoverException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }




}
