package com.example.dissertationproject.controller;

import org.springframework.ui.Model;
import com.example.dissertationproject.dto.UserRegistrationDto;
import com.example.dissertationproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDto userRegistrationDto) {
    userService.save(userRegistrationDto);
    return "redirect:/registration?success";
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "Server is running";
    }
}
