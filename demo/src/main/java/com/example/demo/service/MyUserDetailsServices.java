package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserPrincipal;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class MyUserDetailsServices implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =repo.findByUsername(username);
        if(user==null){
            System.out.println("User is not found.");
            throw new UsernameNotFoundException("User is not found.");
        }
        return new UserPrincipal(user);
    }
}
