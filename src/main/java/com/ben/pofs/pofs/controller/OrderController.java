package com.ben.pofs.pofs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.ben.pofs.pofs.entity.OrderEntity;
import com.ben.pofs.pofs.dao.OrderDao;
import com.ben.pofs.pofs.dao.SaleDao;
import com.ben.pofs.pofs.dto.OrderDto;
import org.springframework.web.bind.annotation.CrossOrigin;

@RequestMapping(path = "/orders")
@RestController
@CrossOrigin // i added this for allow not secure request in forontend
public class OrderController { // resolve error 500

   /*  @Autowired
    private OrderDao orderDao;

    @Autowired
    private SaleDao saleDao;

 
    @PostMapping(path = "/save-order")
    public OrderEntity saveOrder(@RequestBody List<OrderDto> order) {
        return this.saleDao.saveSale(order);
    }*/
    private final OrderDao orderDao;
    private final SaleDao saleDao;
     @Autowired
    public OrderController(OrderDao orderDao, SaleDao saleDao) {
        this.orderDao = orderDao;
        this.saleDao = saleDao;
    }

    @PostMapping("/save-order")
    public ResponseEntity<?> saveOrder(@RequestBody List<OrderDto> order) {
        try {
            if (order == null || order.isEmpty()) {
                return ResponseEntity.badRequest().body("Order cannot be empty");
            }
            OrderEntity savedOrder = this.saleDao.saveSale(order);
            return ResponseEntity.ok(savedOrder);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error saving order: " + e.getMessage());
        }
    }
    @GetMapping("/get-orders")
    public List<OrderEntity> getAllOrders(){
        return this.orderDao.getAllOrders();
    }
}
