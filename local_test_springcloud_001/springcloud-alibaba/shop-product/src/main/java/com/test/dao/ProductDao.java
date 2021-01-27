package com.test.dao;

import com.test.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Li xingbo
 * @date 2020-11-30 14:21
 * @Version 1.0
 */
@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{
}