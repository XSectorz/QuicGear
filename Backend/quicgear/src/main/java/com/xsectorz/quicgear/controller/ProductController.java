/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.xsectorz.quicgear.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author XSectorZ
 */

@RestController
public class ProductController {


    @Value("${server.port}")
    int port;

    @GetMapping("/product")
    public String demo() {
        return "port " + port;
    }
    

}
