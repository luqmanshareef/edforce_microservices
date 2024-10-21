package com.example.mywebapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "Mr. No Name") String name){
        return "Hello " + name + " !!";
    }
}
