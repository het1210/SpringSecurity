package com.springsecurity.SpringSecurity.service.impl;

import com.springsecurity.SpringSecurity.entity.Users;
import com.springsecurity.SpringSecurity.repository.UserRepository;
import com.springsecurity.SpringSecurity.service.JWTService;
import com.springsecurity.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JWTService jwtService;

    @Override
    public Users register(Users user) {
        return userRepository.save(user);
    }

    @Override
    public String verify(Users user) {
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            //to generate token
            jwtService.generateToken(user.getUserName());
            return "success";
        } else {
            return "fail";

        }
    }
}
