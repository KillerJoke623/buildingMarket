package com.auto.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainPageController {
    @Autowired
    public MainPageController(){
    }

    @GetMapping("/")
    public String mainPage() {
        return "mainPage";
    }

    @PostMapping("/")
    public String mainPagepost() {
        return "redirect:/";
    }
}
