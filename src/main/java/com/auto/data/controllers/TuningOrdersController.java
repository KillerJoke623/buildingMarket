package com.auto.data.controllers;

import com.auto.data.models.Service;
import com.auto.data.models.TuningOrders;
import com.auto.data.models.Users;
import com.auto.data.repositories.ServiceRepository;
import com.auto.data.services.TuningOrdersService;
import com.auto.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/service/{serviceId}")
public class TuningOrdersController {
    @Autowired
    private TuningOrdersService tuningOrderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ServiceRepository serviceRepository;

    @PostMapping
    public String createTuningOrder(@ModelAttribute("tuningOrders") TuningOrders tuningOrder, @ModelAttribute("service") Service service) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        tuningOrder.setUser(userService.getUserByEmail(userName));
        tuningOrder.setDateTime(LocalDateTime.now());

        List<Service> servicesList = new ArrayList<Service>();
        servicesList.add(service);

        tuningOrder.setServices(servicesList);
        tuningOrderService.createTuningOrder(tuningOrder);

        return "newTuningOrder";
    }

    @GetMapping
    public String showRegistrationForm(Model model, @PathVariable Integer serviceId) {
        Service service = serviceRepository.findById(serviceId).orElseThrow(() -> new IllegalArgumentException("Service not found"));
        model.addAttribute("service", service);
        model.addAttribute("tuningOrders", new TuningOrders());
        return "newTuningOrder";
    }
}
