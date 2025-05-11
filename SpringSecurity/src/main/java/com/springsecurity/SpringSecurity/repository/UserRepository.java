package com.springsecurity.SpringSecurity.repository;

import com.springsecurity.SpringSecurity.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByUserName(String userName);
}
