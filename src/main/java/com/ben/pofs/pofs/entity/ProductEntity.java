package com.ben.pofs.pofs.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="products")

@Data

@Entity

public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer  productId;

    @Column(name = "product_name")
    private String  productName;

    @Column(name = "product_price")
    private Double  productPrice	;

    @Column(name = "barcode")
    private String  barcode;

     @JsonBackReference
    //@OneToOne
    @OneToMany(mappedBy = "product")
    //@JoinColumn(name = "product_id", insertable = false, updatable = false)
    private List <SaleEntity> sales;
}
