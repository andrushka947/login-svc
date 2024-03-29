package com.master.degree.web_service.exception;

import lombok.Data;

@Data
public class UnauthorizedException extends RuntimeException {

    private String message;

    public UnauthorizedException(String message) {
        super();
        this.message = message;
    }

}
