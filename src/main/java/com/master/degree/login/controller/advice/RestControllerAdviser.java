package com.master.degree.login.controller.advice;

import com.master.degree.login.exception.BadRequestException;
import com.master.degree.login.exception.ResourceNotAvailableException;
import com.master.degree.login.exception.UnauthorizedException;
import com.master.degree.login.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdviser {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleRuntimeException(BadRequestException ex) {
        return new ErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleUnauthorizedException(UnauthorizedException ex) {
        return new ErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(ResourceNotAvailableException.class)
    public ErrorResponse handleResourceNotAvailableException(ResourceNotAvailableException ex) {
        return new ErrorResponse(ex.getMessage());
    }

}
