package com.edforce.order;

import com.edforce.order.entity.Order;
import com.edforce.order.entity.OrderRequest;
import com.edforce.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public Order createOrder(@RequestBody OrderRequest orderRequest){
        return orderService.placeOrder(orderRequest);

    }

}
