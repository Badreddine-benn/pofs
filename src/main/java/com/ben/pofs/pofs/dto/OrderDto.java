package com.ben.pofs.pofs.dto;

//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.PositiveOrZero;

import lombok.Data;

@Data
public class OrderDto {
    private Integer productId;
    private Double productPrice; 

   // Make sure your OrderDto validation is in place:

    /*@NotNull(message = "Product ID cannot be null")
    private Integer productId;
    
    @NotNull(message = "Product price cannot be null")
    @PositiveOrZero(message = "Price must be positive or zero")
    private Double productPrice;*/
}
