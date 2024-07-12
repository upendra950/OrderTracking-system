package com.example.orderTracking.Repository;

import com.example.orderTracking.Entity.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {

    List<Order> findByOrderId(int id);
    
}
