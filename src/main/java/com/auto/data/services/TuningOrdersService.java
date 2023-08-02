package com.auto.data.services;

import com.auto.data.models.TuningOrders;
import com.auto.data.repositories.TuningOrdersRepository;
import org.springframework.stereotype.Service;

@Service
public class TuningOrdersService {

    private TuningOrdersRepository tuningOrderRepository;

    public TuningOrdersService(TuningOrdersRepository tuningOrderRepository) {
        this.tuningOrderRepository = tuningOrderRepository;
    }

    public TuningOrders createTuningOrder(TuningOrders tuningOrder) {
        return tuningOrderRepository.save(tuningOrder);
    }
}
