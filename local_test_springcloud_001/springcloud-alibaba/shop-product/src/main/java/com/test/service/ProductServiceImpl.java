package com.test.service;

import com.test.dao.ProductDao;
import com.test.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author Li xingbo
 * @date 2020-11-30 14:21
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;

    @Override
    public Product findById(Integer id) {
        return productDao.getOne(id);
    }
}