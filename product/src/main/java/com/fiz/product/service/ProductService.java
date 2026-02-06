package com.fiz.product.service;

import com.fiz.product.dto.CreateProductRequest;

public interface ProductService {

    String createProduct(CreateProductRequest request) throws Exception;
}
