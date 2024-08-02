package com.auto.data.services;

import com.auto.data.models.Orders;
import com.auto.data.repositories.OrdersRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private OrdersRepository tuningOrderRepository;

    public OrdersService(OrdersRepository tuningOrderRepository) {
        this.tuningOrderRepository = tuningOrderRepository;
    }

    public Orders createTuningOrder(Orders tuningOrder) {
        tuningOrder.setStatus("pending");
        return tuningOrderRepository.save(tuningOrder);
    }

    public void declineOrder(Long id) {
        Orders tuningOrder = tuningOrderRepository.findById(id).get();
        tuningOrder.setStatus("declined");
        tuningOrderRepository.save(tuningOrder);
    }


}
