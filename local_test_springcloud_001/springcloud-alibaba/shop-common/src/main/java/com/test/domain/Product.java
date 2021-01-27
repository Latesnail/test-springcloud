package com.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author Li xingbo
 * @date 2020-11-26 10:48
 * @Version 1.0
 */
@Entity(name = "shop_product")
@Data
//@Proxy(lazy = false)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double price;

    private Integer stock;
}