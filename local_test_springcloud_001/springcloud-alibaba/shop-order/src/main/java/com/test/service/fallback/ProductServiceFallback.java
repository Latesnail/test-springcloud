package com.test.service.fallback;

import com.test.domain.Product;
import com.test.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author Li xingbo
 * @date 2021-01-26 10:07
 * @Version 1.0
 */
@Component
@Slf4j
public class ProductServiceFallback implements ProductService{
    @Override
    public Product findById(Integer id) {
        Product product = new Product();
        product.setId(-100);
        product.setName("容错处理");
        return product;
    }
}