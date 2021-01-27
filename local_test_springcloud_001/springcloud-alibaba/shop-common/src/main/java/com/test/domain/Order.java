package com.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author Li xingbo
 * @date 2020-11-26 10:35
 * @Version 1.0
 */
@Entity(name = "shop_order")
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //用户
    private Integer userId;

    private String userName;

    //商品
    private Integer productId;

    private String productName;

    private Double productPrice;

    //数量
    private Integer productQuantity;

}