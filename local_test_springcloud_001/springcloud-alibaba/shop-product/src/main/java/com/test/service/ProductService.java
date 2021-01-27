package com.test.service;

import com.test.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @Author Li xingbo
 * @date 2020-11-30 14:21
 * @Version 1.0
 */
public interface ProductService{
    @GetMapping(value = "/product/{pid}")
    Product findById(Integer id);
}