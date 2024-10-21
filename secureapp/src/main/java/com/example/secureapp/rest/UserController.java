package com.example.secureapp.rest;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.example.secureapp.entity.User;
import com.example.secureapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User regsiterUser(User user){
        return userService.registerUser(user);
    }

    @GetMapping("/registerNewUser")
    public User regsiterUser(){
        User user = new User();
        user.setUsername("edforce" + RandomUtil.getPositiveInt());
        user.setPassword("somepass");
        user.setAddress("XYZ");
        return userService.registerUser(user);
    }

    @GetMapping("/test")
    public String test(){
        return "testing";
    }
}
