package com.test.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.test.service.OrderService;
import com.test.service.OrderServiceImpl2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;


/**
 * @Author Li xingbo
 * @date 2020-11-30 16:19
 * @Version 1.0
 */
//@RestController
@Slf4j
public class OrderController3{
    @Autowired
    private OrderServiceImpl2 orderServiceImpl2;

    @RequestMapping("/order/message3")
    @SentinelResource("message3")
    public String message3(String serviceName , String age) {
        return serviceName + age;
    }

    @RequestMapping("/order/message")
    public String message() {
        return orderServiceImpl2.message();
    }


}