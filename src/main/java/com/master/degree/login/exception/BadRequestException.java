package com.master.degree.login.exception;

import lombok.Data;

@Data
public class BadRequestException extends RuntimeException {

    private String message;

    public BadRequestException(String message) {
        super();
        this.message = message;
    }

}
