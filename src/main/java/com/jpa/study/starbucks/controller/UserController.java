package com.jpa.study.starbucks.controller;

import com.jpa.study.starbucks.domain.User;
import com.jpa.study.starbucks.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Log4j2
public class UserController {

    @Autowired
    UserService userService;

    /**
     * localhost:8080/users/getEmail url을 통한
     * JPA user find
     */
    @GetMapping("/getEmail")
    public String getUser() {

        User user = userService.getUser("jys4481@edsk.co.kr");
        String email = user.getEmail();

        log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        log.info("getUser email : " + email);
        log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

        return email;
    }


}
