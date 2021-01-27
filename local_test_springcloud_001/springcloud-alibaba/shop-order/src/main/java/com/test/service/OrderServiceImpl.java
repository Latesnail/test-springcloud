package com.test.service;

import com.test.dao.OrderDao;
import com.test.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Li xingbo
 * @date 2020-11-30 16:20
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;

    @Override
    public Order createOrder(Order order) {
        return orderDao.save(order);
    }
}