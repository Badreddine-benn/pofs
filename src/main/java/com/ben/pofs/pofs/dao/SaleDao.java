package com.ben.pofs.pofs.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.ben.pofs.pofs.entity.SaleEntity;
import com.ben.pofs.pofs.repository.SaleRepo;
import com.ben.pofs.pofs.entity.OrderEntity;
import com.ben.pofs.pofs.dto.OrderDto;

//import lombok.Data;
@Service

//@Data

public class SaleDao {
/* 
    @Autowired
    private SaleRepo saleRepo;

    private OrderDao orderDao;

    public SaleDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }*/ // below i resolved the save-order problem error 500 (not able to acsept redendance) 
    private final SaleRepo saleRepo;
    private final OrderDao orderDao;

    @Autowired
    public SaleDao(SaleRepo saleRepo, OrderDao orderDao) {
        this.saleRepo = saleRepo;
        this.orderDao = orderDao;
    }


    public OrderEntity saveSale(List<OrderDto> order) {

       /*  if (order.size() == 0)
            return null;
        OrderEntity ord = this.orderDao.saveOrder(order);
        order.forEach(o -> {
            SaleEntity sale = new SaleEntity();
            sale.setOrderId(ord.getOrderId());
            sale.setProductId(o.getProductId());
            this.saleRepo.save(sale);
        });

        return ord;*/
   
    if (order == null || order.isEmpty()) {
        throw new IllegalArgumentException("Order cannot be empty");
    }

    try {
        OrderEntity ord = this.orderDao.saveOrder(order);
        order.forEach(o -> {
            SaleEntity sale = new SaleEntity();
            sale.setOrderId(ord.getOrderId());
            sale.setProductId(o.getProductId());
            this.saleRepo.save(sale);
        });
        return ord;
    } catch (Exception e) {
        throw new RuntimeException("Error saving sale: " + e.getMessage());
    }
}

public List<SaleEntity>getSales(){
    return this.saleRepo.findAll();
}
public List<SaleEntity>getSalesOrderId(Integer orderId){
    return this.saleRepo.findAllByOrderId(orderId);
}

}
