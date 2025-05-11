package com.springsecurity.SpringSecurity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Users {
    @Id
    private int id;
    private String userName;
    private String password;
}
