package com.auto.data.services;

import com.auto.data.models.TuningOrders;
import com.auto.data.repositories.TuningOrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuningOrdersService {

    private TuningOrdersRepository tuningOrderRepository;

    public TuningOrdersService(TuningOrdersRepository tuningOrderRepository) {
        this.tuningOrderRepository = tuningOrderRepository;
    }

    public TuningOrders createTuningOrder(TuningOrders tuningOrder) {
        tuningOrder.setStatus("pending");
        return tuningOrderRepository.save(tuningOrder);
    }

    public void declineOrder(Long id) {
        TuningOrders tuningOrder = tuningOrderRepository.findById(id).get();
        tuningOrder.setStatus("declined");
        tuningOrderRepository.save(tuningOrder);
    }


}
