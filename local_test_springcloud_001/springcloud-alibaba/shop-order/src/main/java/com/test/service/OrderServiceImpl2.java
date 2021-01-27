package com.test.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.test.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author Li xingbo
 * @date 2021-01-10 17:39
 * @Version 1.0
 */
//@Service
@Slf4j
public class OrderServiceImpl2 implements OrderService{

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @SentinelResource(value = "message",
            blockHandler = "blockHandler",//指定发生BlockException时进入的方法
            fallback = "fallback"//指定发生Throwable时进入的方法
    )
    public String message() {
        return "message";
    }

    //BlockException时进入的方法
    public String blockHandler(BlockException ex) {
        log.error("{}",ex);
        return "接口被限流或者降级...";
    }

    //fallback时进入的方法
    public String fallback(Throwable throwable) {
        log.error("{}",throwable);
        return "接口发生异常了...";
    }


}