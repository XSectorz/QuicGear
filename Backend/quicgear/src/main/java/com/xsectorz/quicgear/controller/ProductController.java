/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.xsectorz.quicgear.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    
    

}
