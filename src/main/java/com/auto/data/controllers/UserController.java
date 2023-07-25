package com.auto.data.controllers;

import com.auto.data.models.Users;
import com.auto.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") Users newUser) {
        // В этом методе вы можете добавить проверки и обработку данных перед сохранением в базу данных
        userRepository.save(newUser);
        return "redirect:/registration-success";
    }
}
