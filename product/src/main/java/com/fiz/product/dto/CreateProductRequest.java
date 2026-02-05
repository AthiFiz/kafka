package com.fiz.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductRequest {

    private String title;
    private BigDecimal price;
    private Integer quantity;


}
