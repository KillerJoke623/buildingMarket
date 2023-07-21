package com.auto.data.repositiroes;

import com.auto.data.models.TuningOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuningOrdersRepository extends JpaRepository<TuningOrders, Long> {
}