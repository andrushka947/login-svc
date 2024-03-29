package com.master.degree.web_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RootController {

    @GetMapping(path = "/")
    public String root() {
        return "redirect:/web/users";
    }

}
