package com.edforce.order.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OrderRequest {
    Long prodId;
    Integer qty;
}
