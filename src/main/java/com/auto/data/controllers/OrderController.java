package com.auto.data.controllers;

import com.auto.data.models.TuningOrders;
import com.auto.data.repositories.TuningOrdersRepository;
import com.auto.data.services.TuningOrdersService;
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
    private TuningOrdersService orderService;
    @Autowired
    private TuningOrdersRepository tuningOrdersRepository;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/api/orders/{orderId}/decline")
    public void decline(@PathVariable Long orderId) {
//        orderService.declineOrder(orderId);
        TuningOrders tuningOrder = tuningOrdersRepository.findById(orderId).get();
        tuningOrder.setStatus("declined");
        tuningOrdersRepository.save(tuningOrder);
    }

    @GetMapping("/api/orders/{id}")
    public String getOrderById (@PathVariable Long id) throws JSONException {
        TuningOrders tuningOrders = tuningOrdersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("TuningOrder not found"));
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("order_id", tuningOrders.getOrder_id());
        jsonObject.put("comment",tuningOrders.getComment());
        jsonObject.put("status",tuningOrders.getStatus());


        String jsonString = gson.toJson(jsonObject);
        return jsonString;
    }
}
