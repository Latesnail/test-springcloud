package com.test.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
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
public class OrderController2{


    int i=0;

    @RequestMapping("/order/message1")
    public Serializable message1() {
        /*i++;
        if( i % 3 ==0) {
            throw  new RuntimeException();
        }*/

        return "message1";
    }

    @RequestMapping("/order/message2")
    public String message2() {
        return "message2";
    }

    @RequestMapping("/order/message3")
    @SentinelResource("message3")
    public String message3(String serviceName , String age) {
        return serviceName + age;
    }



}