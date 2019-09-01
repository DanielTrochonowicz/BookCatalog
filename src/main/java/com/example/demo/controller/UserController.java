package com.example.demo.controller;


import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @PostMapping("/book-sukcesUserRegistration")
    public String userRegistrationPost(@ModelAttribute User user){
        return "book-sukcesUserRegistration";
    }
}
