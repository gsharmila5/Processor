package com.processing.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.processing.order.model.MemberShip;

@Repository
public interface MemberShipRepository extends JpaRepository<MemberShip, Long>{

}
