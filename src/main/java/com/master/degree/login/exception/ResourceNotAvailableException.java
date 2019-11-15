package com.master.degree.login.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.OK)
public class ResourceNotAvailableException extends RuntimeException {

    private String message;

    public ResourceNotAvailableException(String message) {
        super();
        this.message = message;
    }

}
