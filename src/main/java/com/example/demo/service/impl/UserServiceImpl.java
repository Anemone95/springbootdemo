package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.respository.UserRespository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRespository userRespository;

    @Override
    public User create(User user) {
        userRespository.save(user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRespository.findByUsername(username);
        return user;
    }
}
