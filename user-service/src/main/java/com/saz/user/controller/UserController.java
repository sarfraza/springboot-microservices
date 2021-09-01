package com.saz.user.controller;

import com.saz.user.entity.User;
import com.saz.user.service.UserService;
import com.saz.user.vo.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("inside saveUser() of UserController..");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") Long userId){
        log.info("inside getUserById() of UserController..");
        return userService.getUserById(userId);
    }

}
