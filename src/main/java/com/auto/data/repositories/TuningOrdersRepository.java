package com.auto.data.repositories;

import com.auto.data.models.TuningOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TuningOrdersRepository extends JpaRepository<TuningOrders, Long> {
    @Query("SELECT t FROM TuningOrders t WHERE t.user.user_id = :user_id")
    List<TuningOrders> findByUser_User_id(Long user_id);

}