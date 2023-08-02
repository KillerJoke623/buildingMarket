package com.auto.data.controllers;

import com.auto.data.models.TuningOrders;
import com.auto.data.models.Users;
import com.auto.data.services.TuningOrdersService;
import com.auto.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/newTuningOrder")
public class TuningOrdersController {
    @Autowired
    private TuningOrdersService tuningOrderService;

    @Autowired
    private UserService userService;

    @PostMapping
    public TuningOrders createTuningOrder(@RequestBody TuningOrders tuningOrder) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        tuningOrder.setUser(userService.getUserByEmail(userName));
        tuningOrder.setDateTime(LocalDateTime.now());
        return tuningOrderService.createTuningOrder(tuningOrder);
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("tuningOrders", new TuningOrders());
        return "newTuningOrder";
    }
}
