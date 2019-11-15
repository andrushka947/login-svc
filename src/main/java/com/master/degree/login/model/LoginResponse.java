package com.master.degree.login.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private boolean successful;
    private String errorReason;

    public LoginResponse(boolean successful) {
        this.successful = successful;
    }

}
