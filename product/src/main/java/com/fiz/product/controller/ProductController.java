package com.fiz.product.controller;

import com.fiz.product.dto.CreateProductRequest;
import com.fiz.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody CreateProductRequest request) throws Exception{

        String productId = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }

}
