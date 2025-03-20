package com.ben.pofs.pofs.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ben.pofs.pofs.entity.OrderEntity;
import com.ben.pofs.pofs.repository.OrderRepo;
import com.ben.pofs.pofs.dto.OrderDto;

//import lombok.Data;
@Service

//@Data

public class OrderDao { // resolve error 500
/* 
    @Autowired

    private OrderRepo orderRepo;


    public OrderEntity saveOrder(List<OrderDto> order) {

        Double Total=0.0;

        for(OrderDto o: order) {
            Total+=o.getProductPrice();
        }
            OrderEntity orderEntity= new OrderEntity();

            orderEntity.setTotal(Total);

            return this.orderRepo.save(orderEntity);

    }*/
    private final OrderRepo orderRepo;
    @Autowired
    public OrderDao(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public OrderEntity saveOrder(List<OrderDto> order) {
        try {
            Double total = order.stream()
                .mapToDouble(OrderDto::getProductPrice)
                .sum();

            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setTotal(total);
            return this.orderRepo.save(orderEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error saving order: " + e.getMessage());
        }
    }

    public List<OrderEntity> getAllOrders(){
        return this.orderRepo.findAll();
    }
}
