package com.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author Li xingbo
 * @date 2020-11-28 17:19
 * @Version 1.0
 */
@Data
@Entity(name = "shop_user")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    private String password;

    private String telephone;
}