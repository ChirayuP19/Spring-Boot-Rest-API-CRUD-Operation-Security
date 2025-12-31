package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private UserService service;

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        User registoried = service.registory(user);
        return  registoried;
    }

    @GetMapping("/alluser")
    public List<User> readall(){
        List<User> readall = service.readall();
        return readall;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userEndPoint(){
        return "hello user!";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminEndPoint(){
        return "hello Admin!";
    }
}
