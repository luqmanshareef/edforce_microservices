package com.edforce.order.entity;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    private List<Product> products;
    private Double totalPrice;
    private String shippingAddress;
}
