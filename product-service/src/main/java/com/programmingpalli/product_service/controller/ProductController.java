package com.programmingpalli.product_service.controller;

import com.programmingpalli.product_service.dto.ProductRequest;
import com.programmingpalli.product_service.model.Product;
import com.programmingpalli.product_service.model.ResponseBuilder;
import com.programmingpalli.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getProductById(@PathVariable String id){
        var product=productService.getProductById(id);
        return  new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getAll(Pageable pageable){
       var products= productService.getAllProducts(pageable);
        return ResponseBuilder.ok("Data loaded successfully", products,HttpStatus.OK);
    }


}
