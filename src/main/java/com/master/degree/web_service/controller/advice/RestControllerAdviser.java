package com.master.degree.web_service.controller.advice;

import com.master.degree.web_service.exception.BadRequestException;
import com.master.degree.web_service.exception.ResourceNotAvailableException;
import com.master.degree.web_service.exception.UnauthorizedException;
import com.master.degree.web_service.model.ErrorResponse;
import feign.RetryableException;
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
    @ExceptionHandler(RetryableException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ErrorResponse handleRetryableException(RetryableException ex) {
        return new ErrorResponse("Resource is not available");
    }

}
