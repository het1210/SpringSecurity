package com.springsecurity.SpringSecurity.service;

import com.springsecurity.SpringSecurity.entity.Users;

public interface UserService {
    Users register(Users user);

    String verify(Users user);
}
