package com.ben.pofs.pofs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ben.pofs.pofs.dao.SaleDao;
import com.ben.pofs.pofs.entity.SaleEntity;

@RequestMapping(path="/sales")
@RestController

public class SalesController {

    private final SaleDao saleDao;

    @Autowired
    public SalesController(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

      @GetMapping("/get-sales")
    public List<SaleEntity>getSales(){
    return this.saleDao.getSales();
}
@GetMapping("/get-by-order-id")
public List<SaleEntity>getSalesOrderId(@RequestParam Integer orderId){
    return this.saleDao.getSalesOrderId(orderId);
}
}

