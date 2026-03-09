package org.example.lab1springboot.controller;

import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @PostMapping("/user")
    public String CreateUser(@RequestBody @Valid User user) {

        return "user";


    }
}