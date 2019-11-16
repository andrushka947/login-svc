package com.master.degree.login.controller;

import com.master.degree.login.model.UserDto;
import com.master.degree.login.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getUsers();
    }

    @PostMapping
    public String signup(UserDto userDto, Model model) {
        userService.signup(userDto);

        model.addAttribute("users", userService.getUsers());
        return "redirect:/web/users";
    }

    @GetMapping("/delete/{email:.+}")
    public String delete(@PathVariable("email") String email, Model model) {
        userService.delete(email);

        model.addAttribute("users", userService.getUsers());
        return "redirect:/web/users";
    }

}
