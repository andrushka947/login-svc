package com.master.degree.login.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private boolean successful;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorReason;

    public LoginResponse(boolean successful) {
        this.successful = successful;
    }

}
