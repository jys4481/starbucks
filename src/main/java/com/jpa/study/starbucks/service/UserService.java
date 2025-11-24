package com.jpa.study.starbucks.service;

import com.jpa.study.starbucks.domain.User;
import com.jpa.study.starbucks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String email) {
        return userRepository.findById(email).orElse(null);
    }

    @Transactional
    public User saverUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(String email, User updateUser) {
        User user = getUser(email);
        user.setName(updateUser.getName());
        return userRepository.save(user);
    }


}
