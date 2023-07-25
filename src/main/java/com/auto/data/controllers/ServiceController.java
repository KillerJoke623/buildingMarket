package com.auto.data.controllers;

import org.springframework.ui.Model;
import com.auto.data.models.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.auto.data.repositories.ServiceRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ServiceController {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/services")
    public String getServices(Model model) {
        List<Service> services = serviceRepository.findAll();
        model.addAttribute("services", services);
        return "servicesPage";
    }
}
