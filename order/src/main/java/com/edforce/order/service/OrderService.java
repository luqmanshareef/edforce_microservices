package com.edforce.order.service;

import com.edforce.order.entity.Order;
import com.edforce.order.entity.OrderRequest;
import com.edforce.order.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class OrderService {

    private final String PROD_SERVICE_URL = "http://localhost:8081/";

    public Order placeOrder(OrderRequest orderRequest){

        Order order = new Order();

        System.out.println("Order Request details " + orderRequest.getProdId() + " - " + orderRequest.getQty());

        // retrieve product by given id
        // call the product service - findById endpoint
        // api/products/{id}

        String getProductUrl = PROD_SERVICE_URL + "api/products/" + orderRequest.getProdId();

        System.out.println("URL " + getProductUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> prodResponse = restTemplate.getForEntity(getProductUrl, Product.class);

        Product product = prodResponse.getBody();

        order.setProducts(new ArrayList<>());
        order.getProducts().add(product);
        Double totalPrice = orderRequest.getQty() * product.getPrice();

        order.setTotalPrice(totalPrice);

        return order;
    }
}
