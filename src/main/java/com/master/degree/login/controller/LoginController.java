package com.master.degree.login.controller;

import com.master.degree.login.model.LoginDto;
import com.master.degree.login.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    @PostMapping
    public void login(@RequestBody LoginDto loginDto) {
        loginService.login(loginDto);
    }

}
