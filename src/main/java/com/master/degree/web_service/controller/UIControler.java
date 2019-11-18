package com.master.degree.web_service.controller;

import com.master.degree.web_service.model.UserDto;
import com.master.degree.web_service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
@AllArgsConstructor
public class UIControler {

    private UserService userService;

    @GetMapping(path = "/signup")
    public String signupPage(Model model) {
        model.addAttribute("user", new UserDto());
        return "signup";
    }

    @GetMapping(path = "/users")
    public String usersPage(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

}
