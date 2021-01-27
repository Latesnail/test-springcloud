package com.test.dao;

import com.test.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Li xingbo
 * @date 2020-11-30 16:20
 * @Version 1.0
 */
@Repository
public interface OrderDao extends JpaRepository<Order,Integer>{
}