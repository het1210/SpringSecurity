package com.springsecurity.SpringSecurity.service.impl;

import com.springsecurity.SpringSecurity.entity.UserPrincipal;
import com.springsecurity.SpringSecurity.entity.Users;
import com.springsecurity.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.SpringSecurity.service.MyUserDetailsService;

@Service
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(username);
        if(user == null){
            System.out.println("User Not Found");
            throw  new UsernameNotFoundException("User Not Found");
        }
        return new UserPrincipal(user);
    }
}
