package com.test.controller;

import com.test.domain.Product;
import com.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Li xingbo
 * @date 2020-11-30 14:17
 * @Version 1.0
 */
@RestController
public class ProductController{
    @Qualifier("productServiceImpl")
    @Autowired
    private ProductService productService;

    @RequestMapping("/product/{productId}")
    public Product product(@PathVariable("productId") Integer productId){
        return productService.findById(productId);
    }
}