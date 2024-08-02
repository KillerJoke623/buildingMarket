package com.auto.data.repositories;

import com.auto.data.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query("SELECT t FROM Orders t WHERE t.user.user_id = :user_id")
    List<Orders> findByUser_User_id(Long user_id);

}