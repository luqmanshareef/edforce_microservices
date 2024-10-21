package com.edforce.order;

import com.edforce.order.entity.Order;
import com.edforce.order.entity.OrderRequest;
import com.edforce.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public Order createOrder(@RequestBody OrderRequest orderRequest){
        return orderService.placeOrder(orderRequest);

    }

    @GetMapping("/test")
    public String test(){
        return "Working.........";
    }

}
