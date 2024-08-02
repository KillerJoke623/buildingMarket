package com.auto.web.controllers;

import com.auto.data.models.Users;
import com.auto.data.services.UserService;
import com.auto.web.configurations.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    private final UserDetailsServiceImpl userDetailsService;


    private PasswordEncoder passwordEncoder;


    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginController(UserDetailsServiceImpl userDetailsService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }



    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new Users());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("user") Users user, Model model) {
        // Проверяем, существует ли пользователь с таким email в базе данных
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        if (userDetails != null && passwordEncoder.matches(passwordEncoder.encode(user.getPassword()), userDetails.getPassword())) {
            boolean isthisright = passwordEncoder.matches(passwordEncoder.encode(user.getPassword()), userDetails.getPassword());
            // Если пользователь найден, пытаемся аутентифицировать его
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(),
                            passwordEncoder.encode(user.getPassword())
                    )
            );
            if (authentication.isAuthenticated()) {
                return "redirect:/services";
            }
        }
        else {
            model.addAttribute("errorMessage", "Неверный email или пароль.");
            return "login";
        }


        // Если аутентификация не удалась, перенаправляем пользователя на форму входа с сообщением об ошибке
        model.addAttribute("errorMessage", "Неверный email или пароль.");
        return "login";
    }

}


