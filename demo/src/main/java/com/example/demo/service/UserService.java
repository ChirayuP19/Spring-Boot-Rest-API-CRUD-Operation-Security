package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;


    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public User registory(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        User save = repo.save(user);
        return save;
    }

    public List<User> readall() {
        List<User> all = repo.findAll();
        return all;
    }
}
