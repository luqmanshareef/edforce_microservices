package com.example.secureapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HelloController {

    @GetMapping("/hi")
    public String sayHi(){
        return "Hi!, This is open endpoint....";
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello!, This is secured....";
    }
}
