package com.ben.pofs.pofs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ben.pofs.pofs.entity.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {

}
