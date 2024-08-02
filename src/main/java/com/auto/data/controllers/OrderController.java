package com.auto.data.controllers;

import com.auto.data.models.Orders;
import com.auto.data.repositories.OrdersRepository;
import com.auto.data.services.OrdersService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrdersService orderService;
    @Autowired
    private OrdersRepository ordersRepository;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/api/orders/{orderId}/decline")
    public void decline(@PathVariable Long orderId) {

        Orders tuningOrder = ordersRepository.findById(orderId).get();
        tuningOrder.setStatus("declined");
        ordersRepository.save(tuningOrder);
    }

    @GetMapping("/api/orders/{id}")
    public String getOrderById (@PathVariable Long id) throws JSONException {
        Orders orders = ordersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("TuningOrder not found"));
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("order_id", orders.getOrder_id());
        jsonObject.put("comment", orders.getComment());
        jsonObject.put("status", orders.getStatus());


        String jsonString = gson.toJson(jsonObject);
        return jsonString;
    }
}
