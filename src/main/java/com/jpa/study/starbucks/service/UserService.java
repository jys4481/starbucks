package com.jpa.study.starbucks.service;

import com.jpa.study.starbucks.domain.User;
import com.jpa.study.starbucks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(String email) {
        return userRepository.findById(email).orElse(null);
    }

}
