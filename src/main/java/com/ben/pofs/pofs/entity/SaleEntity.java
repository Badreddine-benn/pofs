package com.ben.pofs.pofs.entity;

import jakarta.persistence.CascadeType;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="sales")

@Data

@Entity

public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Integer  saleId;

    @Column(name = "product_id")
    private Integer  productId;

    @Column(name = "order_id")
    private Integer  orderId;

	/*@Column(name = "created_at")
	private String  Created_At;*/

    //@JsonManagedReference
    //@OneToOne
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;
}