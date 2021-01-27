package com.test.service.fallback;

import com.test.domain.Product;
import com.test.service.ProductService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author Li xingbo
 * @date 2021-01-26 10:16
 * @Version 1.0
 */
@Component
@Slf4j
public class ProductServiceFactoryFallback implements FallbackFactory<ProductService>{
    @Override
    public ProductService create(Throwable throwable) {
        return new ProductService(){
            @Override
            public Product findById(Integer productId) {
                throwable.printStackTrace();
                Product product = new Product();
                product.setId(-100);
                product.setName("容错处理");
                return product;
            }
        };
    }
}