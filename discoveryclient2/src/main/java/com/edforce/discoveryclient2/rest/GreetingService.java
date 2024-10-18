package com.edforce.discoveryclient2.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingService {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello From Greeting Service.......";
    }

}
