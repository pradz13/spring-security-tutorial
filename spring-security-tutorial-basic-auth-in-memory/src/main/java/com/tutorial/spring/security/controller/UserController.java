package com.tutorial.spring.security.controller;

import com.tutorial.spring.security.model.User;
import com.tutorial.spring.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") String userName) {
        return this.userService.getUser(userName);
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

}
