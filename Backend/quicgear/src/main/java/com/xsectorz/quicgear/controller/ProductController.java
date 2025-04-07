/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.xsectorz.quicgear.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xsectorz.quicgear.dto.ProductDto;
import com.xsectorz.quicgear.model.Product;
import com.xsectorz.quicgear.repository.ProductRepository;



/**
 *
 * @author XSectorZ
 */

@RestController
@RequestMapping("/api/v1/")
public class ProductController {


    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<ProductDto> getAllProduct() {
    List<Product> products = productRepository.findAll();

    return products.stream()
        .map(product -> {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setProductName(product.getProductName());
            productDto.setProductDescription(product.getProductDescription());
            
            if (product.getProductImage() != null && !product.getProductImage().isEmpty()) {
                productDto.setProductImages(Arrays.asList(product.getProductImage().split(",")));
            }
            
            productDto.setProductType(product.getProductType());
            productDto.setProductPrice(product.getProductPrice());
            productDto.setProductRating(product.getProductRating());
            productDto.setProductRatingCount(product.getProductRatingCount());
            productDto.setProductStock(product.getProductStock());
            productDto.setProductColor(product.getProductColor());
            return productDto;
        })
        .collect(Collectors.toList());
    }
    
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        
        ProductDto productDto = new ProductDto();
        productDto.setId(product.get().getId());
        productDto.setProductName(product.get().getProductName());
        productDto.setProductDescription(product.get().getProductDescription());
        
        if (product.get().getProductImage() != null && !product.get().getProductImage().isEmpty()) {
            productDto.setProductImages(Arrays.asList(product.get().getProductImage().split(",")));
        }
        
        productDto.setProductType(product.get().getProductType());
        productDto.setProductPrice(product.get().getProductPrice());
        productDto.setProductRating(product.get().getProductRating());
        productDto.setProductRatingCount(product.get().getProductRatingCount());
        productDto.setProductStock(product.get().getProductStock());
        productDto.setProductColor(product.get().getProductColor());

        if (product.isPresent()) {
            return ResponseEntity.ok(productDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
