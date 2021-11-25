package com.processing.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.processing.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
