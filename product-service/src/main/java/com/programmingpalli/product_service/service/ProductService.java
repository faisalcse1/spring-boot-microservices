package com.programmingpalli.product_service.service;

import com.programmingpalli.product_service.dto.ProductRequest;
import com.programmingpalli.product_service.model.Product;
import com.programmingpalli.product_service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {
   private final ProductRepository productRepository;
   public void  createProduct(ProductRequest productRequest){
      Product product = Product.builder()
              .name(productRequest.getName())
              .description(productRequest.getDescription())
              .price(productRequest.getPrice())
              .build();
      productRepository.save(product);
      log.info("product {} saved successfully", product.getId());
   }


   public List<Product> getAllProducts(){
     return productRepository.findAll().stream().toList();
   }
}
