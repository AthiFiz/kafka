package com.fiz.product.controller;

import com.fiz.product.dto.CreateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody CreateProductRequest request){

        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

}
