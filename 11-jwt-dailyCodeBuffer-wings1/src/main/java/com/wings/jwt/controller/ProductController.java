package com.wings.jwt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private record Product(Integer productId, String productName, double price){}

        List<Product> products = new ArrayList<>(
            List.of(
                new Product(1, "iphone", 10000),
                new Product(2, "samsung", 20000)
                )
        );

        @GetMapping
        public List<Product> getproduct(){
            return products;
        }

        @PostMapping
        public Product saveproduct(@RequestBody Product product){
            products.add(product);
            return product;

        }


    }


