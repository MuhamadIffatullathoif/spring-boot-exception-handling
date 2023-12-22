package com.iffat.springboot.error.services;

import com.iffat.springboot.error.models.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
}
