package com.processing.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.processing.order.model.Shipping;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Long>{

}
