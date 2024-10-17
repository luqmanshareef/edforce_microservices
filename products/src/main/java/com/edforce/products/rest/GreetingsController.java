package com.edforce.products.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greetings")
public class GreetingsController {

    @RequestMapping(path = "/greet", method = RequestMethod.GET)
//    @GetMapping("/greet")
    public String sayHi(){
        System.out.println("in greetings........");
        return "Hello!!";
    }
}
