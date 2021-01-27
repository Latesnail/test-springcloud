package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Li xingbo
 * @date 2020-11-30 14:29
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProductApplication{
    public static void main(String[] args){
        SpringApplication.run(ProductApplication.class,args);
    }
}