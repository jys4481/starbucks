package com.jpa.study.starbucks.controller;

import com.jpa.study.starbucks.domain.User;
import com.jpa.study.starbucks.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Startbucks JPA
 * Spring Boot 구조
 * PostMan Tool Url를 통하여
 * select, update, insert, delete 작업 실행
 */
@RestController
@RequestMapping("/users")
@Log4j2
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUser(email));
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userService.saverUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{email}")
    public ResponseEntity<User> updateUser(
            @PathVariable String email,
            @RequestBody User user
            ) {
        return ResponseEntity.ok(userService.updateUser(email, user));
    }

}
