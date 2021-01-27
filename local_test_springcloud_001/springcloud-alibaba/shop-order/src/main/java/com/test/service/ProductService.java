package com.test.service;

import com.test.domain.Product;
import com.test.service.fallback.ProductServiceFactoryFallback;
import com.test.service.fallback.ProductServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Li xingbo
 * @date 2021-01-07 10:10
 * @Version 1.0
 */
@FeignClient(value = "service-product",fallbackFactory = ProductServiceFactoryFallback.class)
//@FeignClient(value = "service-product",fallback = ProductServiceFallback.class)
public interface ProductService{

    @GetMapping(value = "/product/{productId}")
    Product findById(@PathVariable("productId") Integer productId);
}
