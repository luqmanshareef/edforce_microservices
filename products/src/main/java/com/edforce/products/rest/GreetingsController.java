package com.edforce.products.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greetings")
public class GreetingsController {

    @Value("${organization.location}")
    private String location;

    @RequestMapping(path = "/greet", method = RequestMethod.GET)
//    @GetMapping("/greet")
    public String sayHi(){
        System.out.println("in greetings........");
        return "Hello!!  From Product Service running at " + location;
    }
}
