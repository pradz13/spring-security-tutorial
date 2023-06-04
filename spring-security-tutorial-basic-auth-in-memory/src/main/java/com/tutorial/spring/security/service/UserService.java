package com.tutorial.spring.security.service;

import com.tutorial.spring.security.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> userList = new ArrayList<>();

    public UserService() {
        userList.add(new User("abc", "abc", "abc@gmail.com"));
        userList.add(new User("def", "def", "def@gmail.com"));
    }

    public List<User> getAllUsers() {
        return this.userList;
    }

    public User getUser(String userName) {
        return this.userList.stream().filter(user -> user.getUserName().equals(userName)).findFirst().orElse(null);
    }

    public User addUser(User user) {
        this.userList.add(user);
        return user;
    }
}
