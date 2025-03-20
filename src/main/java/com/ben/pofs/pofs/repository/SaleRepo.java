package com.ben.pofs.pofs.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ben.pofs.pofs.entity.SaleEntity;

public interface SaleRepo extends JpaRepository<SaleEntity, Integer>{

    List<SaleEntity> findAllByOrderId(Integer orderId);
}

