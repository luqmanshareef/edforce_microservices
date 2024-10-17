package com.edforce.order.entity;

import lombok.Data;

@Data
public class Product {

    private Long id;

    private String name;

    private Double price;

    private String description;

}
