package com.master.degree.login.controller;

import com.master.degree.login.model.LoginDto;
import com.master.degree.login.model.LoginResponse;
import com.master.degree.login.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @PostMapping
    public LoginResponse login(@RequestBody LoginDto loginDto) {
        return loginService.login(loginDto);
    }

}
