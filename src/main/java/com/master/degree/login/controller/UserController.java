package com.master.degree.login.controller;

import com.master.degree.login.model.ErrorResponse;
import com.master.degree.login.model.UserDto;
import com.master.degree.login.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

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
    public String signup(UserDto userDto, RedirectAttributes redirectAttributes) {
        List<String> emailList = userService.getUsers().stream()
                .map(UserDto::getEmail)
                .collect(Collectors.toList());

        if (emailList.contains(userDto.getEmail())) {
            redirectAttributes.addAttribute("error", "Email is taken");
            return "redirect:/web/signup";
        }

        userService.signup(userDto);
        return "redirect:/web/users";
    }

    @GetMapping("/delete/{email:.+}")
    public String delete(@PathVariable("email") String email, Model model) {
        userService.delete(email);

        model.addAttribute("users", userService.getUsers());
        return "redirect:/web/users";
    }

}
