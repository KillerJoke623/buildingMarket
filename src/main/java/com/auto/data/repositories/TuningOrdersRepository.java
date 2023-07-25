package com.auto.data.repositories;

import com.auto.data.models.TuningOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuningOrdersRepository extends JpaRepository<TuningOrders, Long> {
}